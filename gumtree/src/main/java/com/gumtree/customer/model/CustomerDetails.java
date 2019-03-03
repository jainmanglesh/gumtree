package com.gumtree.customer.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MJain
 *
 * Model class to hold Customer Details
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomerDetails {

	private String firstName;

	private String lastName;

	private String gender;

	private LocalDate birthDate;

	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}
}
