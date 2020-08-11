import java.util.Scanner;

class OneAway2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(isOneEdit(s1,s2));
	}

	static boolean isOneEdit(String s1, String s2){
		//Check Length Difference between strings
		if(Math.abs(s1.length()-s2.length()) > 1)
			return false;

		//Check for the longer string
		String first = s1.length() < s2.length() ? s1 : s2;
		String Second = s1.length() < s2.length() ? s2 : s1;
		int index1 = 0;
		int index2 = 0;
		boolean foundDiff = false;

		while(index1 < first.length() && index2 < Second.length()){
			if(first.charAt(index1) != Second.charAt(index2)){ //if not matching
				//Ensure for the first difference found
				if(foundDiff){
					return false;
				}
				foundDiff = true;

				//check if the lengths are same
				if(first.length() == Second.length()){
					index1++;
				}
			}
			else{
				index1++; //if matching move the shorter pointer
			}
			index2++; //always move pointer for longer string
		}
		return true;
	}
}
