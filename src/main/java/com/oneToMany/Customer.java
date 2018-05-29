package com.oneToMany;

public class Customer {
	private int customerId;
	private String customerName;
	private int forevenId;
	 
	public int getCustomerId() {
	return customerId;
	}
	public void setCustomerId(int customerId) {
	this.customerId = customerId;
	}
	public String getCustomerName() {
	return customerName;
	}
	public void setCustomerName(String customerName) {
	this.customerName = customerName;
	}
	public int getForevenId() {
	return forevenId;
	}
	public void setForevenId(int forevenId) {
	this.forevenId = forevenId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", forevenId=" + forevenId
				+ "]";
	}
	
}
