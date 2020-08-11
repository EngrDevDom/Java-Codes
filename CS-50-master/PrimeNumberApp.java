package com.prime;

/**
 * Generate prime numbers between given range
 * @author sada
 *
 */
public class PrimeNumberApp {

	public static void main(String[] args) {
		for(int i=1;i<=25;i++)
			if(isPrime(i))
				System.out.print(" "+i);
	}

	private static boolean isPrime(int num) {
		boolean isPrime = true;
		for(int i=2;i<num;i++){
			if(num%i==0)
				isPrime =false;
		}
		if(isPrime)
			return isPrime;
		return false;
	}
}
