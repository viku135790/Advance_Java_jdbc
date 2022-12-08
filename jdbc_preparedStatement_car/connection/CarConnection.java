package jdbc_preparedStatement_car.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarConnection {
	static Connection connection=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement_car";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection(url, user, pass);
			if(connection!=null) {
				return connection;
			}
			else {
				System.out.println("something error in the connection please check........");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
