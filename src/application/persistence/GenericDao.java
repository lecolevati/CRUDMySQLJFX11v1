package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	private Connection c;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String user = "root";
		String senha = "P4ssw0rd";
		String myDriver = "com.mysql.cj.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/dbvideojavafx";
	    Class.forName(myDriver);

	    c = DriverManager.getConnection(myUrl, user, senha);
		
		return c;
	}
	
	
}
