package Electricity;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class homepage extends JFrame implements ActionListener
{
    JLabel l1;
    homepage()
    {
        //title set............
                super("Electricity billing system");
		setSize(1600,690);
		//title image set............
		//ImageIcon i1=new ImageIcon("Electricity/icons/ankit_screen_image.jpg");
		//this.setIconImage(i1.getImage());
		
                //screen background image set............
                
                        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/home.jpg"));
                        Image i3=i2.getImage().getScaledInstance(1600,690,Image.SCALE_DEFAULT);
                        ImageIcon icc=new ImageIcon(i3);
                        l1=new JLabel(icc);
                        add(l1);
		//menuebar set............
		//=====================================================================
		//first column
			JMenuBar mb=new JMenuBar();
			JMenu master=new JMenu("Master");
			JMenuItem mi1=new JMenuItem("New Customer");
			JMenuItem mi2=new JMenuItem("Customer Details");
			//JMenuItem mi3=new JMenuItem("Deposit Details");
			master.setForeground(Color.BLUE);

			//NewCustomer details............
			
			Font f=new Font("monospaced",Font.PLAIN,16);
			mi1.setFont(f);
			ImageIcon img_mi1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/men1.png"));
			Image image_mi1=img_mi1.getImage().getScaledInstance(16,20,Image.SCALE_DEFAULT);
			mi1.setIcon(new ImageIcon(image_mi1));
			mi1.setMnemonic('D');
			mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
			mi1.setBackground(Color.WHITE);

			//Customer details............

			mi2.setFont(f);
			ImageIcon img_mi2=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/screen.png"));
			Image image_mi2=img_mi2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			mi2.setIcon(new ImageIcon(image_mi2));
			mi2.setMnemonic('M');
			mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
			mi2.setBackground(Color.WHITE);

			//Deposit details.............

//			mi3.setFont(f);
//			ImageIcon img_mi3=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/ankit_screen_image.jpg"));
//			Image image_mi3=img_mi3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//			mi3.setIcon(new ImageIcon(image_mi3));
//			mi3.setMnemonic('N');
//			mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
//			mi3.setBackground(Color.WHITE);

			mi1.addActionListener(this);
			mi2.addActionListener(this);
			//mi3.addActionListener(this);

			//=====================================================================

			//second column

			JMenu user=new JMenu("User");
			JMenuItem ui1=new JMenuItem("Pay Bill");
//			JMenuItem ui2=new JMenuItem("Calculate Bill");
//			JMenuItem ui3=new JMenuItem("Last Bill");

			//pay bill details..............

			ui1.setFont(f);
			ImageIcon img_ui1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/details.png"));
			Image image_ui1=img_ui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			ui1.setIcon(new ImageIcon(image_ui1));
			ui1.setMnemonic('P');
			ui1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
			ui1.setBackground(Color.WHITE);

			//calculate bill details..............

//			ui2.setFont(f);
//			ImageIcon img_ui2=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/ankit_screen_image.jpg"));
//			Image image_ui2=img_ui2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//			ui2.setIcon(new ImageIcon(image_ui2));
//			ui2.setMnemonic('C');
//			ui2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
//			ui2.setBackground(Color.WHITE);

			//last bill details..............

//			ui3.setFont(f);
//			ImageIcon img_ui3=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/ankit_screen_image.jpg"));
//			Image image_ui3=img_ui3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//			ui3.setIcon(new ImageIcon(image_ui3));
//			ui3.setMnemonic('L');
//			ui3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
//			ui3.setBackground(Color.WHITE);

			ui1.addActionListener(this);
//			ui2.addActionListener(this);
//			ui3.addActionListener(this);

			//=====================================================================

			//third column

			JMenu report=new JMenu("Report");
			JMenuItem r1=new JMenuItem("Generate Bill");
			
			//Generate Bill Details.................

			r1.setFont(f);
			ImageIcon img_r1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/generate.png"));
			Image image_r1=img_r1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			r1.setIcon(new ImageIcon(image_r1));
			r1.setMnemonic('R');
			r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
			r1.setBackground(Color.WHITE);

			r1.addActionListener(this);

			//=====================================================================

			//forth column

//			JMenu utility =new JMenu("Utility");
//			JMenuItem ut1=new JMenuItem("Notepad");
//			JMenuItem ut2=new JMenuItem("Calculator");
//			JMenuItem ut3=new JMenuItem("Web Broswer");

			//notepad details.............

//			ut1.setFont(f);
//			ImageIcon img_ut1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/ankit_screen_image.jpg"));
//			Image image_ut1=img_ut1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//			ut1.setIcon(new ImageIcon(image_ut1));
//			ut1.setMnemonic('Q');
//			ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
//			ut1.setBackground(Color.WHITE);
//
//			//claculator details.............
//
//			ut2.setFont(f);
//			ImageIcon img_ut2=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/ankit_screen_image.jpg"));
//			Image image_ut2=img_ut2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//			ut2.setIcon(new ImageIcon(image_ut2));
//			ut2.setMnemonic('W');
//			ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
//			ut2.setBackground(Color.WHITE);
//
//			//webBroswer details..............
//
//			ut3.setFont(f);
//			ImageIcon img_ut3=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/ankit_screen_image.jpg"));
//			Image image_ut3=img_ut3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//			ut3.setIcon(new ImageIcon(image_ut3));
//			ut3.setMnemonic('O');
//			ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
//			ut3.setBackground(Color.WHITE);
//
//			ut3.addActionListener(this);
//			ut3.addActionListener(this);
//			ut3.addActionListener(this);

			//=====================================================================

			//fifth column
			JMenu exit=new JMenu("Exit");
			JMenuItem ex=new JMenuItem("Exit");

			//exit details....................

			ex.setFont(f);
			ImageIcon img_ex=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/cancle.png"));
			Image image_ex=img_ex.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			ex.setIcon(new ImageIcon(image_ex));
			ex.setMnemonic('Z');
			ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
			ex.setBackground(Color.WHITE);

			ex.addActionListener(this);

			//add menu...........

			master.add(mi1);
			master.add(mi2);
			//master.add(mi3);

			user.add(ui1);
//			user.add(ui2);
//			user.add(ui3);

			report.add(r1);

//			utility.add(ut1);
//			utility.add(ut2);
//			utility.add(ut3);

			exit.add(ex);

			mb.add(master);
			mb.add(user);
			mb.add(report);
			//mb.add(utility);
			mb.add(exit);

			setJMenuBar(mb);

			setFont(new Font("Senserif",Font.BOLD,16));
			setLayout(new FlowLayout());
                        setVisible(false);
    }
	public void actionPerformed(ActionEvent ev)
	{
		String msg=ev.getActionCommand();
		if(msg.equals("New Customer"))
		{
			new new_customer().setVisible(true);
		}
		else if(msg.equals("Customer Details"))
		{
			new customer_details().setVisible(true);
		}
//		else if(msg.equals("Deposit Details"))
//		{
//			new deposit_details().setVisible(true);
//		}
		else if(msg.equals("Pay Bill"))
		{
			new pay_bill().setVisible(true);
		}
//		else if(msg.equals("Calculate Bill"))
//		{
//			System.out.println("Calculate Bill open");
//		}
//		else if(msg.equals("Last Bill"))
//		{
//			System.out.println("Last Bill open");
//		}
//		else if(msg.equals("Notepad"))
//		{
//			try
//			{
//				Runtime.getRuntime().exec("C:/Program Files (x86)/Google/Chrome/Application.chrome.exe");	
//			}
//			catch(Exception e)
//			{
//
//			}			
//		}
//		else if(msg.equals("Last Bill"))
//		{
//			System.out.println("Last Bill open");
//		}
//		else if(msg.equals("Calculator"))
//		{
//			System.out.println("Calculator open");
//		}
		else if(msg.equals("Generate Bill"))
		{
			new generate_bill().setVisible(true);
		}
		else if(msg.equals("Exit"))
		{
			System.exit(0);
		}
		else
		{
			System.out.println("wrong");
		}
	}
	public static void main(String args[])
	{
            new homepage().setVisible(true);
            //obj.setLocation(50,50);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
