package Electricity;
import java.sql.*;
public class connectionclass {
    Connection cn;
    Statement stm;
    public connectionclass()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:330/billing","root","ankit@123");
			stm=cn.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String s[])
	{
		new connectionclass();
	}
}

//Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:330/billing","root","ankit@123");
