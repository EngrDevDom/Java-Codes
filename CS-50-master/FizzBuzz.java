package com.classic;

/**
 * Based on a traditional English children's game
Print the numbers 1..100
For multiples of 3, print "Fizz" instead of the number
For multiples of 5, print "Buzz" instead of the number
For multiples of 3 and 5, print "FizzBuzz" instead of the number
Here: fill an array instead of printing + some other complications
 */

public class FizzBuzz {

	public static void main(String[] args) {
		for(int i=0;i<20;i++){

			System.out.println(
					(i % 15 == 0) ? "FizzBuzz" :
						(i % 3 == 0) ? "Fizz" :
							(i % 5 == 0) ? "Buzz" : i
					);
		}
	}
}		

