package Electricity;
import java.awt.*;
import javax.swing.*;
public class splash_screen{
    public static void main(String s[])
    {
        screen f1=new screen();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1)
        {
            f1.setLocation(700-(i+x)/2,400-(i/2));
            f1.setSize(i+x,i);
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {
            }
        }
    }
}
class screen extends JFrame implements Runnable
{
    Thread t1;
    screen()
    {
	super("Electricity billing System");
	setLayout(new FlowLayout());
    	ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/electricity 1.jpg"));
	Image i1=c1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
	ImageIcon c2=new ImageIcon(i1);
	JLabel l1=new JLabel(c2);
	add(l1);
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t1=new Thread(this);
	t1.start();
    }
    public void run()
    {
        try
        {
            Thread.sleep(7000);
            this.setVisible(false);
            new loginpage().setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

