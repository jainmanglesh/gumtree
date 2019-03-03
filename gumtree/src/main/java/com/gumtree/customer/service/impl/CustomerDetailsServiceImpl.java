package com.gumtree.customer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumtree.customer.service.CustomerDetailsService;
import com.gumtree.customer.service.ReadFileService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	Logger logger = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);

	
	@Autowired
	private ReadFileService readFileService;
	
	/**
	 * @param gender gender to count customer
	 * @return number of customer for provided gender
	 */
	public Long getNumberOfCustomerByGender(String gender) {
		return readFileService
				.getCustomerDetailsAsListFromInputFile()
				.stream()
				.filter(customer -> customer.getGender().equalsIgnoreCase(gender))
				.count();
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
