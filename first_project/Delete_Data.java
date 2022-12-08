package first_project;


/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Data {
	static Connection connection=null;
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/simple_project";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String delete="Delete from student";
			int id=statement.executeUpdate(delete);
			if(id!=0) {
				System.out.println("data deleted.....");
			}
			else {
				System.out.println("data is not found");
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
