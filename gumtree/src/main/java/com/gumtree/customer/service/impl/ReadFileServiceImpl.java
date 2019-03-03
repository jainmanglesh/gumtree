package com.gumtree.customer.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gumtree.customer.model.CustomerDetails;
import com.gumtree.customer.service.ReadFileService;

/**
 * @author Mjain
 *
 * This class is to read the input file and map to java object.
 * 1. input addressbook file is mapped to CustomerDetails object.
 */
@Service
public class ReadFileServiceImpl implements ReadFileService {

	Logger logger = LoggerFactory.getLogger(ReadFileServiceImpl.class);

	@Value("${file.path}")
	private String fileLocation;

	private final String SEPARATOR_COMMA = ",";
	private final String SEPARATOR_SPACE = " ";
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.UK);

	/**
	 * @return a list of customer mapped from address book
	 */
	@SuppressWarnings("resource")
	@Override
	public List<CustomerDetails> getCustomerDetailsAsListFromInputFile() {
		Stream<String> streamStr = null;
		try {
			 streamStr = Files.lines(
					 Paths.get(fileLocation));
		} catch (IOException e) {
			logger.info("File does not exist." + e.getMessage());
			return null;
		}
		if(streamStr == null) {
			logger.info("File does not have content");
			return null;
		}
		List<String> listStr = streamStr.collect(Collectors.toList());
		List<CustomerDetails> listCustomer = new ArrayList<>();
		listCustomer = listStr
			.stream()
			.map(line -> 
				{
					String[] values = line.split(SEPARATOR_COMMA);
					CustomerDetails details = new CustomerDetails();
					String[] fullName = values[0] != null ? values[0].split(SEPARATOR_SPACE):null;
					
					details.setFirstName(fullName[0] != null ? fullName[0].trim():null); //first name
					details.setLastName(fullName[1] != null ? fullName[1].trim():null); //last value
					details.setGender(values[1] != null ? values[1].trim():null); //gender 
					details.setBirthDate(values[2] != null ? LocalDate.parse(values[2].trim(), formatter):null); //birthdate
					return details;
				}
	    	).collect(Collectors.toList());
		return listCustomer;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
