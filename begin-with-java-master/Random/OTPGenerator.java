import java.util.Random;

class OTPGenerator {
	public static void main(String args[]) {
		Random r = new Random();
		int l = 4;
		String str = "0123456789";
		char[] otp = new char[l];
		for(int i=0;i<l;i++) {
			otp[i]=str.charAt(r.nextInt(str.length()));
		}
		String pass = String.valueOf(otp);
		System.out.println(pass);
	}
}