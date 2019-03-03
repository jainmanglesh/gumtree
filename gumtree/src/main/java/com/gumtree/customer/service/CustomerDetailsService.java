package com.gumtree.customer.service;

public interface CustomerDetailsService {

	public Long getNumberOfCustomerByGender(String gender);

	public String getOldestCustomer();

	public Long getAgeDifferenceOfCustomersInDays(String cust1, String cust2);
}
