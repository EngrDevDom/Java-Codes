import java.util.Scanner;
class perpalin2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		System.out.println(isPalindrome(s));
	}

	static boolean isPalindrome(String phrase){
		int countOdd = 0;

		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c: phrase.toCharArray()){
			System.out.print(c+"(");
			int x = getCharNumber(c);
			System.out.print(x+")"+" -> ");
			if(x != -1){
				
				table[x]++;
				System.out.println(table[x]);
				if(table[x] %2 ==1){
					countOdd++;
				}else{

					countOdd--;
				}System.out.println("countOdd == "+countOdd);
			}
		}
		System.out.println("counOdd = "+countOdd);
		return countOdd <= 1;
	}

	static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');

		int val = Character.getNumericValue(c);

		if(a<=val && val<=z)
			return val-a;
		return -1;
	}
}
