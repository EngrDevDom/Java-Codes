package com.fibo;

/**
 * Generate Fibonacci sequence both iteratively and recursively
 * @author sada
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		long ans = fibo(5);
		System.out.println(" "+ans);
		
		long recans = recFib(3);
		System.out.println(" "+recans);
	}
	
	public static long fibo(int n){
		int a=0; int b=1;
		int c=0;
		for(int i=1;i<n;i++){
			
		    c= a+b;
		    a=b;
		    b=c;
		}
		return c;
	}
	
	public static long recFib(int n){
		
//		int n = 0,b=0;
		if((n==1) || (n==2))
		   return 1;
		else
			return recFib(n-1) + recFib(n-2);
//		return 10;
	}
}
