/*Write a program to find how many times a pattern s2 found in s1*/
import java.io.*;
class Prob4
{
	public static void main(String args[])throws IOException 
	{
		String s1,s2;
		int n,count,i;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence: ");
		s1=br.readLine();
		System.out.println("Enter pattern to be searched: ");
		s2=br.readLine();
		count=0;
		for(i=0;i<s1.length();i++)
		{
			 n=s1.indexOf(s2,i);
			if(n != -1)
			{
				System.out.println("<"+s2+"> is found at position "+n);
				count++;
				i=n;
			}
			else
				break;
		}
		if(count != 0)
			System.out.println("No:of times <"+s2+"> is found is= "+count);
		else
			System.out.println("<"+s2+"> is not found");
	}
}