/*Input any number 47315329 as a string.Read the first digit and extract same no:of digits from 2nd position.
Multiply that extracted number by 3*/
import java.io.*;
class Imp3
{
	public static void main(String args[])throws IOException 
	{
		try
		{
			String str,str1;
			int m,n,len,i,len1;;
			double num=0,result;
			int a[]=new int[100];
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter a string: ");
			str=br.readLine();
			len1=str.length();
			n=str.charAt(0);
			m=n-48;
			if(m<(len1-1))
			{
				str1=str.substring(1,m+1);
				//System.out.println(str1);
				len=str1.length();
				for(i=0;i<len;i++)
				{
					a[i]=(str1.charAt(i)-48);
				}
				/*System.out.println("The array is= ");
				for(i=0;i<len;i++)
				{
					System.out.println(a[i]);
				}*/
				for(i=0;i<len;i++)
				{
					num=num+(a[i]*(Math.pow(10,m-1)));
					m--;
				}
				System.out.println(num);
				result=num*3;
				System.out.println("The final result is= "+result);
			}
			else
			{
				System.out.println("Enter a valid string!!");
			}
		}
		catch(Exception e)
		{}
	}
}