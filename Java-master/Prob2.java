/*Bubble Sort using Functions*/
import java.io.*;
class Bubble
{
	int a[]=new int[20];
	int id[]=new int[20];
	int n;
	Bubble(int x[],int y[],int m)
	{
		n=m;
		int i;
		for(i=0;i<m;i++)
		{
			a[i]=x[i];
			id[i]=y[i];
		}
	}
	void bubblesort()
	{
		int temp,temp1,i,j,flag,m;
		flag=0;
		m=n;
		while(flag==0)
		{
			flag=1;
			m=m-1;
			for(i=0;i<m;i++)
			{
				if(a[i]>a[i+1])
				{
					temp=a[i];
					temp1=id[i];
					a[i]=a[i+1];
					id[i]=id[i+1];
					a[i+1]=temp;
					id[i+1]=temp;
					flag=0;
				}
			}
			System.out.println("Pass= "+(i+1));
			for(j=0;j<n;j++)
			{
				System.out.print("a["+j+"]= "+a[j]);
				System.out.print("  ");
				System.out.println("id["+j+"]= "+id[j]);
			}
		}
	}
	void display()
	{
		int i;
		for(i=0;i<n;i++)
		{
			System.out.print("a["+i+"]= "+a[i]);
			System.out.print("  ");
			System.out.println("id["+i+"]= "+id[i]);
		}	
	}
}

class Prob2
{
	public static void main(String args[])throws IOException 
	{
		int n,i;
		int a[]=new int[20];
		int id[]=new int[20];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of the list(<20)= ");
		n=Integer.parseInt(br.readLine());
		System.out.println("Enter "+n+" elements one by one---->");
		for(i=0;i<n;i++)
		{
			System.out.print("a["+i+"]= ");
			a[i]=Integer.parseInt(br.readLine());
			id[i]=i;
		}
		Bubble ob=new Bubble(a,id,n);
		System.out.println("<-----Unsorted List----->");
		System.out.println();
		ob.display();
		ob.bubblesort();
		System.out.println("<-----Sorted List----->");
		System.out.println();
		ob.display();
	}
}