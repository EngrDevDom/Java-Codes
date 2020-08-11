/*Write a program which will arrange the positive and negative numbers in a one-dimensional array in such a way that all positive numbers should come first and then all the negative numbers will come without changing original sequence of the numbers. 
Example: 
Original array contains :  10, -15, 1, 3, -2, 0, -2, -3, 2, -9.
Modified array          :   10, 1, 3, 0, 2, -15, -2, -2, -3, -9.*/
import java.io.*;
class Arrange
{
	public static void main(String args[])throws IOException 
	{
		int n,i,flag,j,temp;
		int a[]=new int[20];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter size of the array= ");
		n=Integer.parseInt(br.readLine());
		System.out.println("Enter "+n+" elements one by one---->");
		for(i=0;i<n;i++)
		{
			System.out.print("a["+i+"]= ");
			a[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("Original Array");
		System.out.println("---------------------");
		for(i=0;i<n;i++)
		{
			if(i==0)
				System.out.print(a[i]);
			else
				System.out.print(","+a[i]);
		}
		flag=0;
		while(flag==0)
		{
			flag=1;
			for(i=0;i<(n-1);i++)
			{
				if(a[i]<0 && a[i+1]>=0)
				{
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					flag=0;
				}
				System.out.println("Pass= "+(i+1));
				for(j=0;j<n;j++)
				{
					if(j==0)
						System.out.print(a[j]);
					else
						System.out.print(","+a[j]);
				}
			}
		}
		System.out.println("Modified Array");
		System.out.println("---------------------");
		for(i=0;i<n;i++)
		{
			if(i==0)
				System.out.print(a[i]);
			else
				System.out.print(","+a[i]);
		}

	}
}