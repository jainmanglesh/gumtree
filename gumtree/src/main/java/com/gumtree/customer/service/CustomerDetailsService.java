package com.gumtree.customer.service;

/**
 * @author MJain
 *
 * Interface for CustomerDetailsServiceImpl class.
 */
public interface CustomerDetailsService {

	public Long getNumberOfCustomerByGender(String gender);

	public String getOldestCustomer();

	public Long getAgeDifferenceOfCustomersInDays(String cust1, String cust2);
}
