import java.io.*;
class Imp9
{
	public static void main(String args[])throws IOException 
	{
		String str,word="",word1="",result="",str1="",file1;
		int i,n,p,choice,x,n1,j,n2;
		String s[]=new String[100];
		char ch,ch1,ch2;
		do
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a sentence= ");
			str=br.readLine();
			str=str+" ";
			n1=str.length();
			p=0;
			x=0;
			for(i=0;i<n1;i++)
			{
				ch1=str.charAt(i);
				if(ch1 != 32)
					str1=str1+ch1;
				else
				{
					s[x++]=str1;
					str1="";
				}
			}
			System.out.println("The original array is---->");
			for(i=0;i<x;i++)
			{
				System.out.println(s[i]);
				System.out.println();
			}
			System.out.println("The sorted array is---->");
			for(i=0;i<x;i++)
			{
				for(j=0;j<x-i-1;j++)
				{
					if(s[j].compareTo(s[j+1])>0)
					{
						String temp=s[j];
						s[j]=s[j+1];
						s[j+1]=temp;
					}
				}
			}
			for(i=0;i<x;i++)
			{
				System.out.println(s[i]+" ");
			}
			str=str.trim();
			n=str.length();
			for(i=0;i<n;i++)
			{
				ch=str.charAt(i);
				if(ch==' ')
					p=i;
			}
			//System.out.println(p);
			for(i=p;i<n;i++)
			{
				ch=str.charAt(i);
				word=word+ch;
			}
			for(i=0;i<p;i++)
			{
				ch=str.charAt(i);
				word1=word1+ch;
			}
			result=word + "," +word1;
			result=result.trim();
			n2=result.length();
			System.out.print("The modified name is: ");
			System.out.println(result);	
			System.out.println("Enter output filename= ");
			file1=br.readLine();
			RandomAccessFile fp1=new RandomAccessFile(file1,"rw");
			for(i=0;i<n2;i++)
			{

				ch2=result.charAt(i);
				fp1.seek(i);
				fp1.write(ch2);
			}
			System.out.println("Copying done---->");
			word="";
			word1="";
			result="";
			System.out.println("Enter 1 to continue");	
			choice=Integer.parseInt(br.readLine());
		}while(choice==1);
		fp1.close();
	}
}