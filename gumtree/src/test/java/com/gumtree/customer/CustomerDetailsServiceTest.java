package com.gumtree.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gumtree.customer.model.CustomerDetails;
import com.gumtree.customer.service.CustomerDetailsService;
import com.gumtree.customer.service.ReadFileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDetailsServiceTest {

	static List<CustomerDetails> listCustomer = new ArrayList<>();

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.UK);


	@Autowired
	CustomerDetailsService customerDetailsService;

	@Mock
	ReadFileService readFileService;

	@BeforeClass
	public static void setCustomerList() {
		CustomerDetails cust1 = new CustomerDetails("Bill", "McKnight", "Male", LocalDate.parse("16/03/1977", formatter));
		CustomerDetails cust2 = new CustomerDetails("Paul", "Robinson", "Male", LocalDate.parse("15/01/1985", formatter));
		CustomerDetails cust3 = new CustomerDetails("Gemma", "Lane", "Female", LocalDate.parse("20/11/1991", formatter));
		CustomerDetails cust4 = new CustomerDetails("Sarah", "Stone", "Female", LocalDate.parse("20/09/1980", formatter));
		CustomerDetails cust5 = new CustomerDetails("Wes", "Jackson", "Male", LocalDate.parse("14/08/1974", formatter));
		listCustomer.add(cust1);
		listCustomer.add(cust2);
		listCustomer.add(cust3);
		listCustomer.add(cust4);
		listCustomer.add(cust5);
	}

	@Test
	public void testGetNumberOfCustomerByGender() {
		when(readFileService.getCustomerDetailsAsListFromInputFile()).thenReturn(listCustomer);

		assertEquals(customerDetailsService.getNumberOfCustomerByGender("male").longValue(), 3L);
		assertEquals(customerDetailsService.getNumberOfCustomerByGender("female").longValue(), 2L);
	}

	@Test
	public void testGetOldestCustomer() {
		
	}

	@Test
	public void testGetAgeDifferenceOfCustomersInDays() {
		
	}
}
