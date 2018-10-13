# SIGNUP-AND-LOGIN
package oxygen.com;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sign_Log {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter id:"); 
		int id=s.nextInt();
		System.out.println("profile_name:"); 
		String pn=s.next();
		System.out.println("username:");
		String u=s.next();
		System.out.println("password:");
		String p=s.next();
		int flag=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/veni","root","");
			Statement stmt=con.createStatement();
			stmt.execute("INSERT INTO login values('"+id+"','"+pn+"','"+u+"','"+p+"')");
			ResultSet rs=stmt.executeQuery("select * from login");
			System.out.println("username:");
			String us=s.next();
			System.out.println("password:");
			String ps=s.next();
			while(rs.next())
			{
				String du=rs.getString(3);
				String dp=rs.getString(4);
				if(us.equals(du) && ps.equals(dp))
				{
				flag=1;
				}
			}
			if(flag==1)
			{
				System.out.println("Login successfull");
			}
			else
			{
				System.out.println("Login failed");
			}
			}
	

catch(SQLException e)
		{
	System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
	System.out.println(e);
		}
}
		

		}


