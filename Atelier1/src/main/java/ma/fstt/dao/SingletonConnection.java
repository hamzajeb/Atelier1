package ma.fstt.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static Connection cnx; 
	private SingletonConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cnx=DriverManager.getConnection("jdbc:mysql://localhost/atelier1","root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnexion() throws ClassNotFoundException {
		if(cnx==null) {
			new SingletonConnection();
		}
		return cnx;
	}
}
