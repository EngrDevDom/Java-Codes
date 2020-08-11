package studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {
	
public static void main(String args[]) {
	
		//Ask how many students we want to add
		System.out.println("Enter the number of students to enroll: ");
		Scanner scan = new Scanner(System.in);
		
		int numOfStudents = scan.nextInt();
		
		Student[] student = new Student[numOfStudents];
	
		//create n number of students 
		for(int i=0;i<numOfStudents;i++) {
			student[i] = new Student();
			student[i].enroll();
			student[i].payTuition();
			System.out.println(student[i].showInfo());
		}
		
		
	}
}
