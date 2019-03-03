package com.gumtree.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gumtree.customer.service.CustomerDetailsService;
import com.gumtree.customer.service.ReadFileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDetailsServiceTest {

	@Autowired
	CustomerDetailsService customerDetailsService;

	@Mock
	ReadFileService readFileServiceImpl;

	@Test
	public void testGetNumberOfCustomerByGender() {
		
	}
}
