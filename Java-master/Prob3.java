/*Define 1-dimensional array a[20]. Store maximum 'n' (1-20) distinct numbers in a[]. Calculate and print the following :

i) Sum of 'n' number(s)

ii) Average of 'n' numbers(avg)

iii) Maximum number(max)

iv) Standard deviation (sd).

Use constructor and inheritance*/
import java.io.*;
class Sum
{
	int a[]=new int[20];
	int n;
	Sum(int x[],int m)
	{
		int i;
		n=m;
		for(i=0;i<n;i++)
			a[i]=x[i];
	}
	int sum()
	{
		int s=0,i;
		for(i=0;i<n;i++)
		{
			s=s+a[i];
		}
		return s;
	}
	int large()
	{
		int i;
		int max=a[0];
		for(i=1;i<n;i++)
		{
			if(a[i]>max)
				max=a[i];
		}
		return max;
	}
}
class Average extends Sum
{
	Average(int x[],int m)
	{
		super(x,m);
	}
	float Average()
	{
		float avg;
		int sum=sum();
		avg=sum/(float)n;
		return avg;
	}
}
class S_Dev extends Average
{
	S_Dev(int x[],int m)
	{
		super(x,m);
	}
	float s_dev()
    {
        float avg,sd;
        int i;
        avg=Average();
        sd=0;
        for(i=0;i<n;i++)
            sd=sd+(avg-a[i])*(avg-a[i]);
        sd=(float)Math.sqrt((double)(sd/n));
        return sd;
     }
}
class Prob3
{
	public static void main(String args[])throws IOException 
	{
		int a[]=new int[20];
		int n,i,sum,large;
		float s_dev,avg;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of the array(<20)= ");
		n=Integer.parseInt(br.readLine());
		System.out.println("Enter "+n+" elements one by one---->");
		for(i=0;i<n;i++)
			a[i]=Integer.parseInt(br.readLine());
		S_Dev ob=new S_Dev(a,n);
		sum=ob.sum();
		large=ob.large();
		avg=ob.Average();
		s_dev=ob.s_dev();
		System.out.println("Sum is= "+sum);
		System.out.println("Largest value= "+large);
		System.out.println("Average is= "+avg);
		System.out.println("Standard Deviation= "+s_dev);
	}
}
