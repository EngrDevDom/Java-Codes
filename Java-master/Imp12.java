/*WAP to read data of a file and convert each byte to 8 bits.Complement all prime position bits.
Perform XOR operation between bit 1 and bit 2 and substitute in bit 2 position. Similarly bit 3 with bit 4 
then substitute in bit 4 position. Continue upto bit n-1 and bit n. Reverse the whole bit pattern and then 
again complement the bits in prime position of the bit pattern. Read 2 consecutive bits to form the DNA sequence*/
import java.io.*;
class Imp12
{
	public static void main(String args[])throws IOException 
	{
		String file1,file2,file3,file4,file5,file6,file7;
		int bit[]=new int[100];
		int mask,i,k,ch,p,q,j,m,n;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter input filename= ");
		file1=br.readLine();
		System.out.print("Enter bit filename= ");
		file2=br.readLine();
		System.out.print("Enter bit prime filename= ");
		file3=br.readLine();
		System.out.print("Enter XOR filename= ");
		file4=br.readLine();
		System.out.print("Enter reverse pattern filename= ");
		file5=br.readLine();
		System.out.print("Enter bit prime 2 filename= ");
		file6=br.readLine();
		System.out.println("Enter output filename= ");
		file7=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		FileOutputStream fp2=new FileOutputStream(file2);
		FileOutputStream fp3=new FileOutputStream(file3);
		FileOutputStream fp4=new FileOutputStream(file4);
		FileOutputStream fp5=new FileOutputStream(file5);
		FileOutputStream fp6=new FileOutputStream(file6);
		FileOutputStream fp7=new FileOutputStream(file7);
		p=0;
		q=0;
		while((ch=fp1.read())!=-1)
		{
			mask=128;
			i=7;
			q=p+8;
			while(mask>0)
			{
				k=ch & mask;
				if (k!=0)
					bit[i]=1;
				else
					bit[i]=0;
				i--;
				mask=mask>>1;
			}
			p=q;
			for(i=7;i>=0;i--)
			{
				fp2.write(bit[i]+48);
			}
			if(bit[1]==1)
				bit[1]=0;
			else
				bit[1]=1;

			if(bit[3]==1)
				bit[3]=0;
			else
				bit[3]=1;

			if(bit[5]==1)
				bit[5]=0;
			else
				bit[5]=1;

			if(bit[7]==1)
				bit[7]=0;
			else
				bit[7]=1;

			for(i=7;i>=0;i--)
			{
				fp3.write(bit[i]+48);
			}
			fp4.write(bit[0]+48);
			for(i=7;i>=1;i--)
			{
				if((bit[i]==0 && bit[i-1]==1) || (bit[i]==1 && bit[i-1]==0))
				{
					bit[i]=1;
				}
				else
					bit[i]=0;
				fp4.write(bit[i]+48);
			}
			int count=0;
			for(j=7;j>=0;j--)
			{
				fp5.write(bit[j]+48);
			}
			for(i=1;i<=7;i++)
			{
				for(j=i;j<=7;j++)
				{
					if(i%j==0)
						count++;
				}
				if(count==2)
				{
					if(bit[j]==0)
						bit[i]=1;
					else
						bit[i]=0;
				}
			}
			for(i=7;i>=0;i--)
			{
				fp6.write(bit[i]+48);
			}
			for(j=7;j>=1;j=-2)
			{
				m=bit[j];
				n=bit[j-1];
				if(m==0 && n==0)
					fp7.write('A');
				else if(m==0 && n==1)
					fp7.write('C');
				else if(m==1 && n==0)
					fp7.write('T');
				else
					fp7.write('G');
			}
		}
		//System.out.println(q);
		fp1.close();
		fp2.close();
		fp3.close();
		fp4.close();
		fp5.close();
		fp6.close();
		fp7.close();
	}
}

