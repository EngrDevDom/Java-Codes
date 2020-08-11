package com.arrays;

/**
 * Solution to the classic Dutch National Flag problem
 * Sort an array of 0s, 1s and 2s
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * e.g.
 * Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 * Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 * @author sada
 */

import java.util.Arrays;

public class DNFProblem {

	public static void main(String[] args) {
		int []input = new int[]{1,0,1,2,2,1,0,1,2,1,0,0};

		System.out.println("input:  "+Arrays.toString(input));
		sort012(input, input.length-1);
	}

	private static void sort012(int[] input, int end) {
		int start = 0;
		int mid = 0;
		while(mid<end){
			switch(input[mid]) {
			case 0:
				//swap mid and start
				//increment strat
				swap(input, mid,start);
				start++;
				mid++;
				break;
			case 1:
				//increment mid
				mid++;
				break;
			case 2:
				//decrement end;
				//swap mid and end
				swap(input,mid,end);
				end--;
				break;
			}
		}
		System.out.println("output: "+Arrays.toString(input));
	}

	private static void swap(int[] input, int a, int b) {
		int temp;
		temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
}
