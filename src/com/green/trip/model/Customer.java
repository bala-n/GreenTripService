package com.green.trip.model;

public class Customer {
	
	long customerId;
	private String firstName;
	private String lastName;
	private String nickName;
	private String custType;
	long vehicleId;
	private String custEmail;
	private String custContact;
	long custLocId;
	private String custStatus;
	
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustContact() {
		return custContact;
	}
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	public long getCustLocId() {
		return custLocId;
	}
	public void setCustLocId(long custLocId) {
		this.custLocId = custLocId;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}


}
