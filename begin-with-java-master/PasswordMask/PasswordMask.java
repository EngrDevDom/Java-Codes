import java.io.Console;

class PasswordMask {
	public static void main(String args[]) {
		Console con = System.console();
		if(con == null) {
			System.out.println("Console not found");
			return;
		}
		System.out.print("Enter password : ");
		char pwd[]=con.readPassword();
		String pass=String.valueOf(pwd);
		System.out.println("Password : "+pass);
	}
}