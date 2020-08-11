import java.io.*;

class Imp1
{
	public static void main(String args[])throws IOException 
	{
		String file1,file2;
		int ch,ch1,ch2,ch3,nc;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter input filename= ");
		file1=br.readLine();
		System.out.print("Enter output filename= ");
		file2=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		FileOutputStream fp2=new FileOutputStream(file2);
		nc=0;
		while((ch=fp1.read())!=-1)
		{
			if(ch==34)
			{
				fp2.write(ch);
				ch=fp1.read();
				while(ch!=34)
				{
					fp2.write(ch);
					ch=fp1.read();
				}
				fp2.write(ch);
			}
			else if((char)ch=='/')
			{
				ch=fp1.read();
				if((char)ch=='/')
				{
					nc++;
					ch1=fp1.read();
					while(ch1 != 10)
					{
						ch1=fp1.read();
					}
				}
				//fp2.write(ch);
				else if((char)ch=='*')
				{
					nc++;
					ch2=fp1.read();
					do
					{
						ch3=fp1.read();
						if((char)ch2=='*' && (char)ch3=='/')
							break;
						ch2=ch3;
					}while(1==1);
				}
				else
				{
					fp2.write(ch);
				}
			}
			else
				fp2.write(ch);
		}
		System.out.println("No:of comments removed ="+nc);
		fp1.close();
		fp2.close();
	}
}