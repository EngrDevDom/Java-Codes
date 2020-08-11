import java.io.*;
class Imp10
{
	public static void main(String args[])throws IOException 
	{
		String file1,file2,str="",str1="",str2="";
		int len,i,n,count=0;
		int ch;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter input filename= ");
		file1=br.readLine();
		System.out.println("Enter output filename= ");
		file2=br.readLine();
		System.out.println("Enter a pattern to be searched= ");
		str=br.readLine();
		System.out.println("Enter the replacing pattern= ");
		str2=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		FileOutputStream fp2=new FileOutputStream(file2);
		len=file1.length();
		while((ch=fp1.read())!=-1)
		{
			str1=str1+(char)ch;
		}
		System.out.println("The original string is= "+str1);
		for(i=0;i<str1.length();i++)
		{
			n=str1.indexOf(str,i);
			if(n!=-1)
			{
				System.out.println("<"+str+"> is found at position="+n);
				count++;
				i=n;
			}
			else
				break;
		}
		str2=str1.replace(str,str2);
		System.out.println("The new string is= "+str2);
		if(count != 0)
			System.out.println("No:of times <"+str+"> is found = "+ count);
		else
			System.out.println("<"+str+"> is not found");
		for(i=0;i<str2.length();i++)
		{
			ch=str2.charAt(i);
			fp2.write(ch);
		}
		System.out.println("Copying done---->");
		fp1.close();
		fp2.close();
	}
}