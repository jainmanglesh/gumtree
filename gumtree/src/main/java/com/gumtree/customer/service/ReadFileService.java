package com.gumtree.customer.service;

import java.util.List;

import com.gumtree.customer.model.CustomerDetails;

/**
 * @author MJain
 *
 * Interface for ReadFileServiceImpl class
 */
public interface ReadFileService {

	public List<CustomerDetails> getCustomerDetailsAsListFromInputFile();
	
}
