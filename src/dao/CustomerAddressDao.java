package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAddressDao 
{
	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	private String query;
	
	public int insertCustomerAddress(model.CustomerAddress customerAddress)
	{
		query = "insert into customerAddress (address, state, city, pinCode) values(?,?,?,?)";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customerAddress.getAddress());
			preparedStatement.setString(2, customerAddress.getState());
			preparedStatement.setString(3, customerAddress.getCity());
			preparedStatement.setString(4, customerAddress.getPinCode());
			return preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
		finally 
		{
			ConnectionManager.closeConnection(connection);
		}
	}
	
	public int getCustomerAddressId(model.CustomerAddress customerAddress)
	{
		query = "select id from customerAddress where address = ? AND state = ? AND city = ? AND pinCode = ?";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customerAddress.getAddress());
			preparedStatement.setString(2, customerAddress.getState());
			preparedStatement.setString(3, customerAddress.getCity());
			preparedStatement.setString(4, customerAddress.getPinCode());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				return resultSet.getInt(1);
			else
				return -1;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
		finally 
		{
			ConnectionManager.closeConnection(connection);
		}
	}
	
	public model.CustomerAddress getCustomerAddress(int customerAddressId)
	{
		model.CustomerAddress customerAddress;
		query = "select * from customerAddress where id = ?";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customerAddressId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				customerAddress = new model.CustomerAddress(customerAddressId, resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}
			else
			{
				customerAddress = null;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			customerAddress = null;
		}
		finally 
		{
			ConnectionManager.closeConnection(connection);
		}
		return customerAddress;
	}
	
}
