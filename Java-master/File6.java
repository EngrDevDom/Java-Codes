/*Write a java program to calculate and print
(i) number of vowels
(ii) number of consonants
(iii) Number of lines
(iv) number of spaces in any text file.*/
import java.io.*;
class File6
{
	public static void main(String args[])throws IOException 
	{
		String file1;
		int ch,vowels=0,consonants=0,count=0,flag,words=0,lines=0;
		char ch1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the filename=");
		file1=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		flag=1;
		while((ch=fp1.read())!=-1)
		{
			if(ch==10)
				lines++;
			if((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
			{
				count++;
				if(flag==1)
				{
					words++;
					flag=0;
				}

			}
			else if(flag==0)
			{
				flag=1;
			}
			ch1=(char)ch;
			if(ch1=='A'||ch1=='E'||ch1=='I'||ch1=='O'||ch1=='U'||ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u')
				vowels++;
		}
		consonants=count-vowels;
		System.out.println("No:of lines= "+(lines-1));
		System.out.println("No:of vowels= "+vowels);
		System.out.println("No:of consonants= "+consonants);
		System.out.println("No:of words= "+words);
		System.out.println("No:of spaces= "+(words-1));
	}
}