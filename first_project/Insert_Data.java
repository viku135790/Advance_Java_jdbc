package first_project;

/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Data {
	static Connection connection=null;
	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection
			String url="jdbc:mysql://localhost:3306/simple_project";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			//create the statement
			Statement statement=connection.createStatement();
			
			
			//insert
			String insert="insert into student values(124,'anshul','anshl@gmail.com')";
			
			//statements execute
			statement.execute(insert);
			
			System.out.println("data inserted");
		} 
		catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		finally {
			//close the connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
