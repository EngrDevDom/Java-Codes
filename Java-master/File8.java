/*Write a Java program to input any file name.
Convert the content of the file into bits ( 0 and 1).
/*Write the bits in one output file.
Read two bits at a time and convert into DNA sequence as follows: A=00, C=01, T=10 and G=11.
Write DNA sequence in another output file. Display size of bit file and also DNA file.*/
import java.io.*;
class File8
{
	public static void main(String args[])throws IOException 
	{
		String file1,file2,file3;
		int ch,mask,i,k,j,m,n,count=0,s1=0,s2=0;
		int bit[]=new int[8];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter input filename= ");
		file1=br.readLine();
		System.out.println("Enter output filename1= ");
		file2=br.readLine();
		System.out.println("Enter output filename2= ");
		file3=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		FileOutputStream fp2=new FileOutputStream(file2);
		FileOutputStream fp3=new FileOutputStream(file3);
		while((ch=fp1.read())!=-1)
		{
			count++;
			mask=128;
			i=7;
			while(mask > 0)
			{
				k=ch & mask;
				if(k!=0)
					bit[i]=1;
				else
					bit[i]=0;
				i--;
				mask=mask>>1;
			}
			for(j=7;j>=0;j--)
			{
				++s1;
				fp2.write(bit[j]+48);
			}
			++s1;
			for(j=7;j>=0;j-=2)
			{
				n=bit[j];
				m=bit[j-1];
				++s2;		
				if(n==0 && m==0)
					fp3.write('A');
				else if(n==0 && m==1)
					fp3.write('C');
				else if(n==1 && m==0)
					fp3.write('T');
				else
					fp3.write('G');
			}
			++s2;
		}
		System.out.println("No:of bits in input file= "+count);
		System.out.println("No:of bytes in bit file= "+s1);
		System.out.println("No:of bits in decoded file= "+s2);
		fp1.close();
		fp2.close();
		fp3.close();
	}
}