//Write a program in java to copy from more than one input file to one output file
import java.io.*;
class File4
{
	public static void main(String args[])throws IOException 
	{
		long n,i,s=0;
		int ch,argc,j;
		argc=args.length;
		FileOutputStream fp2=new FileOutputStream(args[argc-1]);
		for(j=0;j<argc-1;j++)
		{
			RandomAccessFile fp1=new RandomAccessFile(args[j],"r");
			n=fp1.length();
			System.out.println("Size of file <"+args[j]+">="+n+" bytes");
			for(i=0;i<n;i++)
			{
				s=s+n;
				ch=fp1.read();
				fp2.write(ch);
			}
			fp1.close();
		}
		fp2.close();
		System.out.println("Copying is over---->");
		System.out.println("No:of bytes copied="+s+" bytes");
	}
}