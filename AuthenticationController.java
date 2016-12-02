import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class AuthenticationController implements IAuthentication {

	@Override
	public boolean login(String username, String password) throws Exception {
//		JPasswordField pasEncrypt = new JPasswordField();
		
		DBConnection dbConn = new DBConnection();
		dbConn.openConnection();
		String queryString = "SELECT id, password FROM \"user\";";
		ResultSet result = dbConn.executeQueryStatement(queryString);
//		
////	
		try{
			while (result.next()) {
//				pasEncrypt.setText(result.getString(2));
//				System.out.println("pass from table" + pasEncrypt.getPassword().toString());
				System.out.println("pass from pass" + password);
				System.out.println("id from id"+ username);
				System.out.println(result.getString(2));
				System.out.println(result.getString(1));
				if(result.getString(1).equals(username) && result.getString(2).equals(password))
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

}
