package model;

public class Customer
{
	
	private int customerId ;
	private String name ;
	private String email_id ;
	private long phone_no ;
	private int addressId;
	
	
	public Customer(int customerId, String name, String email_id, long phone_no, int addressId) 
	{
		super();
		this.customerId = customerId;
		this.name = name;
		this.email_id = email_id;
		this.phone_no = phone_no;
		this.addressId = addressId;
	}
	

	public Customer(String name, String email_id, long phone_no, int addressId) 
	{
		super();
		this.name = name;
		this.email_id = email_id;
		this.phone_no = phone_no;
		this.addressId = addressId;
	}


	/**
	 * @return the customerId
	 */
	public int getCustomerId()
	{
		return customerId;
	}
	
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the phone_no
	 */
	public long getPhone_no() 
	{
		return phone_no;
	}

	/**
	 * @param phone_no the phone_no to set
	 */
	public void setPhone_no(long phone_no) 
	{
		this.phone_no = phone_no;
	}

	/**
	 * @return the email_id
	 */
	public String getEmail_id() 
	{
		return email_id;
	}

	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) 
	{
		this.email_id = email_id;
	}


	/**
	 * @return the addressId
	 */
	public int getAddressId() 
	{
		return addressId;
	}


	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) 
	{
		this.addressId = addressId;
	}
	
}
