import java.util.*;

class permuPalin{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		String pali = sc.nextLine();   //"rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}
	static boolean isPermutationOfPalindrome(String phrase){
		int[] table = buildCharFreqTable(phrase);
		return checkMaxOneOdd(table);
	}
	static boolean checkMaxOneOdd(int[] table){
		boolean foundOdd = false;
		for(int count: table){
			if(count % 2 ==1){
				if (foundOdd){
				return false;}
			foundOdd = true;
		}
		}
			return true;
		
		}
	static int[] buildCharFreqTable(String phrase){
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c: phrase.toCharArray()){
			System.out.print(c+" -> ");
			int x = getCharNumber(c);
			System.out.println(x);

			if(x!= -1){
				table[x]++;
				System.out.println(table[x]);
				
			}}
	
		return table;
	}

	static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');

		int val = Character.getNumericValue(c);
		if(a <= val && val <= z){
		return val - a;
		}
	return -1;
	}	
}
