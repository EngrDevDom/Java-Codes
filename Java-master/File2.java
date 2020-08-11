/*write a program to reverse the contents of one file in another output file*/
import java.io.*;
class File2
{
	public static void main(String args[]) throws IOException 
	{
		String file1,file2;
		int ch;
		long n,i;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter input filename=");
		file1=br.readLine();
		System.out.println("Enter output filename=");
		file2=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		FileOutputStream fp2=new FileOutputStream(file2);
		n=fp1.length();
		for(i=n-1;i>=0;i--)
		{
			fp1.seek(i);
			ch=fp1.read();
			fp2.write(ch);
		}
		fp1.close();
		fp2.close();
	}
}