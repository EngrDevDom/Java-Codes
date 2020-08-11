//Write a program to convert all small letters to capital letters in any program/text file.
import java.io.*;
class File9
{
	public static void main(String args[])throws IOException 
	{
		String file1,file2;
		int ch;
		long n,i;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter input filename= ");
		file1=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"rw");
		n=fp1.length();
		for(i=0;i<n;i++)
		{
			fp1.seek(i);
			ch=fp1.read();
			if(ch>=65 && ch<=90)
			{
				ch=ch+32;
				fp1.seek(i);
				fp1.write(ch);
			}
			else if(ch>=97 && ch<=122)
			{
				ch=ch-32;
				fp1.seek(i);
				fp1.write(ch);
			}
			else
			{
				fp1.seek(i);
				fp1.write(ch);
			}
		}
		fp1.close();
	}
}
