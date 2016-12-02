
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		DBConnection dbConn = new DBConnection();
//		dbConn.openConnection();
		FrameTest frame = new FrameTest();
		
		System.out.println("Connection Success");
		
		
		
		String sqlcommand = "SELECT name, year FROM public.\"long\" ";
//		String ban = "SELECT \"Address\", \"FirstMiter\", \"LastMiter\", \"Password\", \"Result\", \"Type\", \"Username\",\"Rate\" FROM public.\"data\" ";
//		String aa ="SELECT \"Address\", \"FirstMiter\", \"LastMiter\", \"Password\", \"Result\", \"Type\", \"Username\",\"Rate\" FROM  public.\"data\" ORDER BY \"Password\" = '1234' ,\"Username\" = 'may1234'  ";
		String ban = "SELECT \"id\", \"password\" FROM public.\"user\" ";
		String aa ="SELECT \"Address\", \"FirstMiter\", \"LastMiter\", \"Result\", \"Type\", \"Rate\" FROM  public.\"data\" ORDER BY \"Password\" = '1234' ,\"Username\" = 'may1234'  ";
//		ResultSet result = dbConn.executeQueryStatement(ban);
//		System.out.println(result.toString());
//	
//		try{
//			if(!result.next()){
//				JOptionPane.showMessageDialog(null, "Wrong Username and Password.");
//			}
//			else{		
//				System.out.println("Login Success");
//			
//			System.out.println("username: " + result.getString(1));
//			System.out.println("password: " + result.getString(2));
//				
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
		String a1 = "JOy1"; 
		String a2 = "JOy2"; 
		String a3 = "JOy3"; 
		String a4 = "JOy4"; 
		String a5 = "JOy5"; 
		String a6 = "JOy6"; 
//		String id = "a";
//		String password = "b";
		//String sql = "insert into \"long\" value ('"+a+"','"+b+"')" ;
	//	String sqll = "INSERT INTO \"long\"(name, year)VALUES ('"+a+"', '"+b+"');" ;
		String s = "INSERT INTO public.\"data\"(\"Address\", \"FirstMiter\", \"LastMiter\", \"Result\", \"Type\", \"Rate\")VALUES ('"+a1+"', '"+a2+"', '"+a3+"', '"+a4+"', '"+a5+"', '"+a6+"');" ;
//		String user = "INSERT INTO public.\"user\"(\"id\", \"password\");" ;
		
	try{
		Connection cc = dbConn.openConnection2();
			Statement stm = cc.createStatement() ;
         stm.execute(s);
//         stm.execute(user);
		} catch (SQLException ex) {
            System.out.println("error");
            
      }
		
		
		
		
	}
}
