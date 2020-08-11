/*Write a Java program to extract all words from a input sentence.
Sort those words in alphabetical order.
Display all those  sorted  words on screen.
The program should also display how many words were extracted.*/
import java.io.*;
class File7
{
	public static void main(String args[])throws IOException 
	{
		String string1,word="",temp="";
		String arr[]=new String[100];
		int n,x=0,i,flag,j;
		char ch;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence: ");
		string1=br.readLine();
		string1=string1+" ";
		n=string1.length();
		flag=1;
		i=0;
		while(i < n)
		{
			ch=string1.charAt(i);
			if((ch >= 65 && ch<=90) || (ch >= 97 && ch <= 122))
			{
				if(flag==1)
				{
					flag=0;
				}
				word=word+ch;
				i=i+1;
			}
			else if(flag==0)
			{
				arr[x++]=word;
				word="";
				flag=1;
				i=i+1;
			}
		}
		System.out.println("<----Unsorted Array---->");
		for(i=0;i<x;i++)
			System.out.println(arr[i]);

		for(i=0;i<x;i++)
		{
			for(j=0;j<x-i-1;j++)
			{
				if(arr[j].compareTo(arr[j+1])>0)
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("<----Sorted List---->");
		for(i=0;i<x;i++)
			System.out.println(arr[i]);
	}
}