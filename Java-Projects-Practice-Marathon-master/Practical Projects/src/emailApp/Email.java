package emailApp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 9;
	private String alternateEmail;
	private String companySuffix = "manikroton.com";
	
	//Constructor to receive the first and last name
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		//call a method asking for the department - return department
		this.department = setDepartment();
		
		//use of this.department is optional because there's no other varibale named department
		//System.out.println("Selected Department: " + department);
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Suggested Password: " + this.password);
		
		//combine elements to create email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	//Ask for the department
	private String setDepartment() {
		
		System.out.println("New Employee: " + firstName + "\nEnter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
		Scanner in = new Scanner(System.in);
		
		int depChoice = in.nextInt();
		
		if(depChoice == 1) return "sales";
		else if(depChoice == 2) return "dev";
		else if(depChoice == 3) return "accut";
		else return "";
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789#$%&";
		char[] password = new char[length];
		
		for(int i=0;i<length;i++) {
			
			//bracketing Math.random() * passwordSet.length() is important. Otherwise wrong outputs produced
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password 
	public void changePassword(String password) {
		this.password = password;
	}
	
	
	//getter methods 
	public int getMailboxCapactiy() {
		return mailboxCapacity;
	}
	
	public String getAltEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName
				+ "\n" + "COMPANY EMAIL: " + email 
				+ "\n" + "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
				
	}
	
}
