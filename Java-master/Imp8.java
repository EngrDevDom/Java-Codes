
import java.io.*;
class Imp8
{
	public double runge4_function(double x,double y)
	{
		double y1;
		y1=y+0*x;
		return y1;
	}
	public double runge4(double x0,double y0,double h)
	{
		double k1,k2,k3,k4,y1;
		k1=h*runge4_function(x0,y0);
		k2=h*runge4_function(x0+h*0.5,y0+k1*0.5);
		k3=h*runge4_function(x0+h*0.5,y0+k2*0.5);
		k4=h*runge4_function(x0+h,y0+k3);
		y1=y0+(1.0/6.0)*(k1+2*k2+2*k3+k4);
		return y1;
	}
	public static void main(String args[])throws IOException 
	{
		double x0,y0,xn,h,x1,y1;
		int n,i;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter x0= ");
		x0=Double.parseDouble(br.readLine());
		System.out.print("Enter y0= ");
		y0=Double.parseDouble(br.readLine());
		System.out.print("Enter xn= ");
		xn=Double.parseDouble(br.readLine());
		System.out.print("Enter h= ");
		h=Double.parseDouble(br.readLine());
		n=(int)((xn-x0)/h);
		Imp8 ob=new Imp8();
		for(i=1;i<=n;i++)
		{
			x1=x0+i*h;
			y1=ob.runge4(x0,y0,h);
			System.out.println("x1= "+x1+",y1= "+y1);
			y0=y1;
		}
	}
}