package ma.fstt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {

	static Connection connexion =null;
	
	private ConnexionBDD() {}
	
public static Connection connect() {
	

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_commandes","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	return connexion;	
}
}
