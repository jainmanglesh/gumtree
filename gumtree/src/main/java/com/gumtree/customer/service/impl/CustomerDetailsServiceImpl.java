package com.gumtree.customer.service.impl;

import static java.time.temporal.ChronoUnit.DAYS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	@Override
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

	/**
	 * @return Full name of the oldest customer
	 */
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

	/**
	 * @param cust1 first name of first customer to get the age difference
	 * @param cust2 first name of second customer to get the age difference
	 * @return The age difference in number of days.
	 */
	@Override
	public Long getAgeDifferenceOfCustomersInDays(String cust1, String cust2) {
		List<CustomerDetails> listCustomerDetails = readFileService
				.getCustomerDetailsAsListFromInputFile();
		List<CustomerDetails> custToFindAgeDiff = new ArrayList<>();
		if(listCustomerDetails != null) {
			custToFindAgeDiff = listCustomerDetails
				.stream()
				.filter(x -> (x.getFirstName().equalsIgnoreCase(cust1) 
						|| x.getFirstName().equalsIgnoreCase(cust2))
				).collect(Collectors.toList());
		}
		if(custToFindAgeDiff.size() == 2) {
			return DAYS.between(custToFindAgeDiff.get(0).getBirthDate(), custToFindAgeDiff.get(1).getBirthDate());
		} else {
			logger.info("customer doesnt exists in file");
			return null;
		}
	}
}
