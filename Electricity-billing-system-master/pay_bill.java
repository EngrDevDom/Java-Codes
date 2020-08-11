package Electricity;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class pay_bill extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    JTextArea t1;
    Choice c1,c2;
    JPanel p,p1;
    Font f;
    pay_bill()
    {
        super("Pay Bill");
        setLocation(200,200);
        setSize(1000,400);
        setResizable(false);
        f=new Font("senserif",Font.BOLD,15);
        l1=new JLabel("Meter No");
        l2=new JLabel("Month");
        l3=new JLabel("Units Consumed");
        l5=new JLabel("Calculate Electricity Bill");
        l5.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l5.setFont(f);
        
        c1=new Choice();
        c1.add("1001");
        c1.add("1002");
        c1.add("1003");
        c1.add("1004");
        c1.add("1005");
        c1.add("1006");
        c1.add("1007");
        c1.add("1008");
        c1.add("1009");
        c1.add("1010");
        
        c1.setFont(f);
        
        c2=new Choice();
        c2.add("january");
        c2.add("fabruary");
        c2.add("march");
        c2.add("april");
        c2.add("may");
        c2.add("june");
        c2.add("july");
        c2.add("august");
        c2.add("september");
        c2.add("octuber");
        c2.add("nubmber");
        c2.add("december");
        
        c2.setFont(f);
        
        t1=new JTextArea();
        
        t1.setFont(f);
        
        b1=new JButton("Submit");
        b2=new JButton("Cancle");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setFont(f);
        b2.setFont(f);
        
        b1.setSize(50,50);
        p=new JPanel();
        p.setLayout(new GridLayout(4,2,30,30));
        p.add(l1);
        p.add(c1);
        p.add(l2);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/paybill2.png"));
        Image img=ig.getImage().getScaledInstance(270,270,Image.SCALE_DEFAULT);
        ImageIcon ig2=new ImageIcon(img);
        l4=new JLabel(ig2);
        p1.add(l4);
        
        setLayout(new BorderLayout(30,30));
        //setLayout(new GridLayout(1,2,1,1));
        add(l5,"North");
        add(p1,"West");
        add(p,"Center"); 
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource()==b1)
        {
            try
            {
                connectionclass obj=new connectionclass();
                String meter=c1.getSelectedItem();
                String month=c2.getSelectedItem();
                int units=Integer.parseInt(t1.getText());
                int amount=(units*7)+98+42+112+48;
                String q="insert into bill values('"+meter+"','"+month+"','"+units+"','"+amount+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Data Successfull inserted......");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(ev.getSource()==b2)
        {
            JOptionPane.showMessageDialog(null,"you pressed cancel");
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new  pay_bill().setVisible(true);
    }
}
