package web;

import dao.ConnectionManager;
import dao.CustomerAddressDao;
import dao.CustomerDao;
import model.Customer;
import model.CustomerAddress;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	private CustomerAddressDao customerAddressDao;
	
	public void init() 
	{
		customerDao = new CustomerDao();
		customerAddressDao = new CustomerAddressDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			if(request.getParameter("insert") != null)
			{
				insertCustomer(request, response);
			}
			else if(request.getParameter("edit") != null)
			{
				showEditForm(request, response);
			}
			else if(request.getParameter("update") != null)
			{
				updateCustomer(request, response);
			}
			else if(request.getParameter("delete") != null)
			{
				deleteCustomer(request, response);
			}
			else
			{
				listCustomer(request, response);
			}
		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}

	private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
	{
		List<Customer> listCustomer = customerDao.selectAllCustomer();
		List<CustomerAddress> listCustomerAddress = new ArrayList<>();
		for(Customer customer : listCustomer)
		{
			listCustomerAddress.add(customerAddressDao.getCustomerAddress(customer.getAddressId()));
		}
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listCustomerAddress", listCustomerAddress);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerList.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("edit"));
		Customer existingCustomer = customerDao.getCustomer(id);
		CustomerAddress customerAddress = customerAddressDao.getCustomerAddress(existingCustomer.getAddressId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerUpdateForm.jsp");
		request.setAttribute("customer", existingCustomer);
		request.setAttribute("customerAddress", customerAddress);
		dispatcher.forward(request, response);

	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
	{
		String name = request.getParameter("name");
		String email_id = request.getParameter("email_id");
		long phone_no = Long.parseLong(request.getParameter("phone_no"));
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String pinCode = request.getParameter("pinCode");
		
		CustomerAddress customerAddress = new CustomerAddress(address, state, city, pinCode);
		int addressId = customerAddressDao.getCustomerAddressId(customerAddress);
		if(addressId == -1)
		{
			if(customerAddressDao.insertCustomerAddress(customerAddress) != -1)
			{
				addressId = customerAddressDao.getCustomerAddressId(customerAddress);
			}
			else
			{
				
			}
		}
		
		Customer customer = new Customer(name, email_id, phone_no, addressId);
		if(customerDao.insertCustomer(customer) != -1)
		{
			//listCustomer(request, response);
		}
		//listCustomer(request, response);
		
		response.sendRedirect("index.jsp");
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email_id = request.getParameter("email_id");
		long phone_no = Long.parseLong(request.getParameter("phone_no"));
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String pinCode = request.getParameter("pinCode");
		
		CustomerAddress customerAddress = new CustomerAddress(address, state, city, pinCode);
		int addressId = customerAddressDao.getCustomerAddressId(customerAddress);
		if(addressId == -1)
		{
			if(customerAddressDao.insertCustomerAddress(customerAddress) != -1)
			{
				addressId = customerAddressDao.getCustomerAddressId(customerAddress);
			}
			else
			{
				
			}
		}

		Customer customer = new Customer(id, name, email_id, phone_no, addressId);
		customerDao.updateCustomer(customer);
		listCustomer(request, response);
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
	{
		int customerId = Integer.parseInt(request.getParameter("delete"));
		customerDao.deleteCustomer(customerId);
		response.sendRedirect("index.jsp");
	}

}