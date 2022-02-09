package model;

public class CustomerAddress 
{
	private int addressId;
	private String address;
	private String state;
	private String city;
	private String pinCode;
	

	public CustomerAddress(int addressId, String address, String state, String city, String pinCode) 
	{
		super();
		this.addressId = addressId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
	}
	
	

	public CustomerAddress(String address, String state, String city, String pinCode)
	{
		super();
		this.address = address;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
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

	/**
	 * @return the address
	 */
	public String getAddress() 
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) 
	{
		this.address = address;
	}

	/**
	 * @return the state
	 */
	public String getState() 
	{
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) 
	{
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() 
	{
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) 
	{
		this.city = city;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() 
	{
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) 
	{
		this.pinCode = pinCode;
	}
	
}
