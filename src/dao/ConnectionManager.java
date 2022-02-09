package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager 
{
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/customer_management_system";
	private static final String USER="root";
	private static final String PASSWORD="";
	
	public static Connection getConnection() 
	{
		Connection connection;
		try 
		{
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USER,PASSWORD); 
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			connection = null;
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection)
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
