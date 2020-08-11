import java.io.*;
import java.awt.*;
import java.applet.*;
public class Imp4 extends Applet 
{
	TextField t1,t2,t3,t4;;
	public void init()
	{
		t1=new TextField(5);
		t2=new TextField(5);
		t3=new TextField(10);
		t4=new TextField(8);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
	}
	public void paint(Graphics g)
	{
		int a=0,b=0,c=0;
		String str;
		g.drawString("Enter number a= ",50,100);
		g.drawString("Enter number b= ",50,150);
		g.drawString("Enter Functions= ",50,200);
		str=t3.getText();
		a=Integer.parseInt(t1.getText());
		b=Integer.parseInt(t2.getText());
		if (str.compareTo("add")==0)
		{
			c=a+b;
			t4.setText(String.valueOf(c));
		}
		else if(str.compareTo("sub")==0)
		{
			c=a-b;
			t4.setText(String.valueOf(c));	
		}
		else if(str.compareTo("mul")==0)
		{
			c=a*b;
			t4.setText(String.valueOf(c));
		}
		else
		{
			c=a/b;
			t4.setText(String.valueOf(c));
		}
	}
}