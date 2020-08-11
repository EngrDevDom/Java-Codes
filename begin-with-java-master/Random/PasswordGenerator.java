import java.util.Random;

class PasswordGenerator {
	public static void main(String args[]) {
		Random r = new Random();
		String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small = "abcdefghijklmnopqrstuvwxyz";
		String digit = "0123456789";
		String special = "!@#$%^&*_<>?";
		String str = capital + small + digit + special;
		int l = 6;
		char[] arr = new char[l];
		for(int i=0;i<arr.length;i++) {
			arr[i]=str.charAt(r.nextInt(str.length()));
		}
		String pass = String.valueOf(arr);
		System.out.println(pass);
	}
}