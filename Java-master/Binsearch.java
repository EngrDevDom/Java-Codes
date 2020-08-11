/*1. Write a program to input maximum 20 numbers in one dimensional array a[20] and their index in another array id[20]. 
Input number (say num) to be searched in the list. Use Binary search method to search that number in the list
and print whether the number is found or number is not found.*/
import java.io.*;
class Binsearch
{
	public static void main(String args[])throws IOException 
	{
		int n,i,j,temp,temp1,ele,low,high,mid,flag,p;
		int a[]=new int[20];
		int id[]=new int[20];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter size of the array(<20)= ");
		n=Integer.parseInt(br.readLine());
		System.out.println("Enter "+n+" elements one by one---->");
		for(i=0;i<n;i++)
		{
			System.out.print("a["+i+"]= ");
			a[i]=Integer.parseInt(br.readLine());
			id[i]=i;
		}
		System.out.println("Enter the element to be searched= ");
		ele=Integer.parseInt(br.readLine());
		System.out.println("<-----Unsorted List----->");
		for(i=0;i<n;i++)
		{
			System.out.print("a["+i+"]= "+a[i]);
			System.out.print("  ");
			System.out.println("id["+i+"]= "+id[i]);
		}
			for(i=0;i<n;i++)
			{
				for(j=0;j<n-i-1;j++)
				{
					if(a[j]>a[j+1])
					{
						temp=a[j];
						temp1=id[j];
						a[j]=a[j+1];
						id[j]=id[j+1];
						a[j+1]=temp;
						id[j+1]=temp1;
					}
				}
			}
			System.out.println("<-----Sorted List----->");
			for(i=0;i<n;i++)
			{
				System.out.print("a["+i+"]= "+a[i]);
				System.out.print("  ");
				System.out.println("id["+i+"]= "+id[i]);
			}
			low=0;
			high=n-1;
			mid=(high+low)/2;
			flag=0;
			p=0;
			while(low<=high)
			{
				if(ele == a[mid])
				{
					flag=1;
					p=id[mid];
					break;
				}
				else if(ele < a[mid])
					high=mid-1;
				else
					low=mid+1;
				mid=(high+low)/2;
			}
			if(flag==1)
			{
				System.out.println("Element "+ele+" is found at position "+p);
			}
			else
				System.out.println("Element "+ele+" not found");
	}
}
