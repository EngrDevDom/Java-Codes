	import java.applet.*;
import java.awt.*;
import java.io.*;
public class Imp13 extends Applet 
{
	public void paint(Graphics g)
	{
		setBackground(Color.pink);
		Font f1=new Font("New Times Roman",Font.BOLD,50);
		g.setFont(f1);
		g.drawString("Indian National Flag Dedicated to the #unbeaten man",100,100);
		g.drawRect(200,200,500,320);
		g.drawRect(200,300,500,120);
		g.setColor(Color.orange);
		g.fillRect(200,200,500,120);
		g.setColor(Color.white);
		g.fillRect(200,300,500,125);
		g.setColor(Color.green);
		g.fillRect(200,400,500,120);
		g.setColor(Color.blue);
		g.drawArc(400,300,100,100,0,360);
		g.drawLine(450,300,450,400);
		g.drawLine(400,350,500,350);
		g.drawLine(490,315,413,380);
		g.drawLine(413,315,490,380);
		//g.drawLine(420,310,493,383);
	}

}