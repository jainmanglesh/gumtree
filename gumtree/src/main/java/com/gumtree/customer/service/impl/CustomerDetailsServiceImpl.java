package com.gumtree.customer.service.impl;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumtree.customer.model.CustomerDetails;
import com.gumtree.customer.service.CustomerDetailsService;
import com.gumtree.customer.service.ReadFileService;

/**
 * @author MJain
 *
 * Class for Customer details related operation.
 */
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
		List<CustomerDetails> listCustomerDetails = readFileService
				.getCustomerDetailsAsListFromInputFile();
		if(listCustomerDetails != null) {
			return listCustomerDetails
				.stream()
				.filter(customer -> customer.getGender().equalsIgnoreCase(gender))
				.count();
		}
		return 0L;
	}

	@Override
	public String getOldestCustomer() {
		List<CustomerDetails> listCustomerDetails = readFileService
				.getCustomerDetailsAsListFromInputFile();
		if(listCustomerDetails != null) {
			return listCustomerDetails
				.stream()
				.min(Comparator.comparing(CustomerDetails::getBirthDate))
				.get()
				.getFullName();
		}
		return null;
	}

	@Override
	public Long getAgeDifferenceOfCustomersInDays(String cust1, String cust2) {
		return null;
	}
}
