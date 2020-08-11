package com.string;

import java.util.Arrays;

/**
 * code to check if given input strings are anagrams
 * e.g. skeep and peeks are anagrams 
 * @author sada
 *
 */
public class AnagramsApp {

	public static void main(String[] args) {

		System.out.println(" "+isAnagram("skeep", "peeks"));
		System.out.println(" "+isAnagram("Mother In Law", "Hitler Woman"));
		
		System.out.println("2nd way "+isAnagramViaCollections("skeep", "peeks"));
	}

	private static boolean isAnagramViaCollections(String string, String string2) {
		char []str1 = string.toCharArray();
		Arrays.sort(str1);
		
		char []str2 = string2.toCharArray();
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
		
	}

	private static boolean isAnagram(String str, String str2){
		str = str.replaceAll("\\s", "").toLowerCase();
		str2 = str2.replaceAll("\\s", "").toLowerCase();
		
		if(str.length()!=str2.length())
			return false;
		
		char[] strCharArr = str.toCharArray();
		StringBuilder sb = new StringBuilder(str2);
		int charIndex;
		for(char c : strCharArr){
			charIndex = sb.indexOf(""+c);
			if(charIndex!=-1)
				sb.deleteCharAt(charIndex);
			else
				return false;
		}
		return sb.length()==0 ? true : false;
	}
}
