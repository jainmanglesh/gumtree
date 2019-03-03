package com.gumtree.customer.service;

import java.util.List;

import com.gumtree.customer.model.CustomerDetails;

public interface ReadFileService {

	public List<CustomerDetails> getCustomerDetailsAsListFromInputFile();
	
}
