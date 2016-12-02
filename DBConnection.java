

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    String url ;
    String user ;
    String password ;
    Connection dbConn ;
    
   public DBConnection(){  
	   
   }
   public DBConnection(String user, String pwd, String url){
	   this.user = user;
	   this.password = pwd;
	   this.url = url;
	   
   }
   public void openConnection() {
	   try {
           Class.forName("org.postgresql.Driver");
           String url
           = "jdbc:postgresql://localhost:5433/postgres";
           String userName = "postgres" ;
           String password = "1234" ;
           dbConn  = DriverManager.getConnection
                   (url,userName, password);
          
       }catch(Exception e){
    	   e.printStackTrace();
       }
   }
   public Connection openConnection2() {
	   try {
           Class.forName("org.postgresql.Driver");
           String url
           = "jdbc:postgresql://localhost:5433/postgres";
           String userName = "postgres" ;
           String password = "1234" ;
           dbConn  = DriverManager.getConnection
                   (url,userName, password);
           return dbConn;
          
       }catch(Exception e){
    	   e.printStackTrace();
       }
	   return null;

   }
   
    public void closeConnection(){ 
    		
    } 
    
    public ResultSet executeQueryStatement(String sqlCommand){ 
    	ResultSet result = null;
    	try {
    		
			Statement statement = dbConn.createStatement();
			result = statement.executeQuery(sqlCommand);
		//	while(result.next()){
				//System.out.println("user name:" + result.getString(0));
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return result;
    	
    }
    public boolean executeInsertUpdateStatement(String sqlCommand){
    	return true;
    }
    
    
    
    
}
