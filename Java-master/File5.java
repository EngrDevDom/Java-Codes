//Write a program to extract words from an input file 
import java.io.*;
class File5
{
	public static void main(String args[])throws IOException 
	{
		String file1,file2,word="",temp="",w="";
		int ch,flag,nw,x=0,i,j,n;
		char ch1;
		String arr[]=new String[100];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter input filename");
		file1=br.readLine();
		System.out.println("Enter output filename");
		file2=br.readLine();
		RandomAccessFile fp1=new RandomAccessFile(file1,"r");
		FileOutputStream fp2=new FileOutputStream(file2);
		flag=1;
		nw=0;
		while((ch=fp1.read())!=-1)
		{
			if((ch>=65 && ch<=90)||(ch>=97 && ch<=122))
			{
				if(flag==1)
				{
					nw++;
					flag=0;
				}
				word=word+(char)ch;
				//System.out.print(word);
			}
			else if(flag==0)
			{
				arr[x++]=word;
				word="";
				System.out.println();
				flag=1;
			}
		}
		System.out.println("No:of words Extracted are= "+nw);
		System.out.println("<----Unsorted List---->");
		for(i=0;i<x;i++)
			System.out.println(arr[i]);
		System.out.println("<----Sorted List---->");
		for(i=0;i<x;i++)
		{
			for(j=0;j<x-i-1;j++)
			{
				if(arr[j].compareTo(arr[j+1])>0)
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					/*System.out.println("Step= "+i+" Pass= "+j);
					for(j=0;j<x;j++)
						System.out.println(arr[j]);*/
				}
			}
		}
		for(i=0;i<x;i++)
			System.out.println(arr[i]);

		for(i=0;i<x;i++)
		{
			w=arr[i];
			w=w+" ";
			n=w.length();
			for(j=0;j<n;j++)
			{
				ch1=w.charAt(j);
				fp2.write(ch1);
			}
		}
		fp1.close();
		fp2.close();
		System.out.println("Copying is done---->");
	}
}