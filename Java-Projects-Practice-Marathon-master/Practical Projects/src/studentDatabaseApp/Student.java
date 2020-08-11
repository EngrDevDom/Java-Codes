package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	//Constructor: prompt user to enter student's name and year
	public Student(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Student's First Name: ");
		this.firstName = scan.nextLine();
		
		System.out.print("Enter Student's Last Name: ");
		this.lastName = scan.nextLine();
		
		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter Student's Grade Level: ");
		this.gradeYear = scan.nextInt();
		
		setStudentID();		
	}
	
	//Generate and ID
	private void setStudentID() {
		id++;
		//gradelevel + ID
		this.studentID =  gradeYear + "" + id;
	}
	
	//Enroll in courses
	public void enroll() {
		
		do {
			System.out.println("Enter courses to enroll(Q to quit): ");
			Scanner scan = new Scanner(System.in);
			String course = scan.nextLine();
			
			if(course.equals("Q")) break;

			courses = courses + "\n" + course;
			tuitionBalance = tuitionBalance + costOfCourse;
			
		} while(1>0);
			
		System.out.println("TUTION BALANCE: " + tuitionBalance);
	}
	
	//View balance
	public void viewBalance() {
		System.out.println("Your tution balance: $" + tuitionBalance);
	}
	
	//Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment $");
		Scanner scan = new Scanner(System.in);
		int payment = scan.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank your for your payment of $" + payment);
		viewBalance();
	}
	
	//Show status
	public String showInfo() {
		return "Name: " + firstName + " " + lastName + 
				"\nGrade Level: " + gradeYear + 
				"\nStudent ID: " + studentID + 
				"\nCourses Enrolled: " + courses + 
				"\nBalance: " + tuitionBalance;
	}
}
