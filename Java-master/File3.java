//Write a program to copy from one input file to one output file 
import java.io.*;
class File3
{
	public static void main(String args[]) throws IOException 
	{
		long n,i;
		int ch;
		RandomAccessFile fp1=new RandomAccessFile(args[0],"r");
		FileOutputStream fp2=new FileOutputStream(args[1]);
		n=fp1.length();
		for(i=0;i<n;i++)
		{
			ch=fp1.read();
			fp2.write(ch);

		}
		fp1.close();
		fp2.close();
		System.out.println("Copying is over");
		System.out.println("No:of bytes copied="+n+" bytes");
	}
}