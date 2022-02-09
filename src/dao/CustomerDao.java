package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao
{
	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	private String query;
	
	public int insertCustomer(model.Customer customer)
	{
		query = "insert into customer (name, email_id, phone_no, addressId) values(?,?,?,?)";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail_id());
			preparedStatement.setLong(3, customer.getPhone_no());
			preparedStatement.setInt(4, customer.getAddressId());
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
	
	public model.Customer getCustomer(int customerId)
	{
		query = "select * from customer where id = ?";
		model.Customer customer;
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				customer = new model.Customer(customerId, resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getInt(5));
			}
			else
			{
				customer = null;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			customer = null;
		}
		finally 
		{
			ConnectionManager.closeConnection(connection);
		}
		return customer;
	}
	
	public int updateCustomer(model.Customer customer)
	{
		query = "update customer set name = ?, email_id = ?, phone_no = ?, addressId = ? where id = ?";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail_id());
			preparedStatement.setLong(3, customer.getPhone_no());
			preparedStatement.setInt(4, customer.getAddressId());
			preparedStatement.setInt(5, customer.getCustomerId());
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
	
	public int deleteCustomer(int customerId)
	{
		query = "delete from customer where id = ?";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customerId);
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

	public List<model.Customer> selectAllCustomer()
	{
		List<model.Customer> listCustomer = new ArrayList<>();
		model.Customer customer;
		query = "select * from customer";
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				customer = new model.Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
						resultSet.getLong(4), resultSet.getInt(5));
				listCustomer.add(customer);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			listCustomer = null;
		}
		finally 
		{
			ConnectionManager.closeConnection(connection);
		}
		return listCustomer;
	}
}
