package first_project;

/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display_Data {
	static Connection connection=null;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/simple_project";
			String user="root";
			String pass="tiger";
			connection =DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String display="select * from student";
			
			ResultSet resultset=statement.executeQuery(display);
			
			while(resultset.next()) {
				System.out.println("id = "+resultset.getInt(1));
				System.out.println("name = "+resultset.getString(2));
				System.out.println("email = "+resultset.getString(3));
			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
	}

}
