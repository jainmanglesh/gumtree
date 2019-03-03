package com.gumtree.customer.service.impl;

import org.springframework.stereotype.Service;

import com.gumtree.customer.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Override
	public Long getNumberOfCustomerByGender(String gender) {
		return null;
	}

	@Override
	public String getOldestCustomer() {
		return null;
	}

	@Override
	public Long getAgeDifferenceOfCustomersInDays(String cust1, String cust2) {
		return null;
	}
}
