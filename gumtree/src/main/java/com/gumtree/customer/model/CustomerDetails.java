package com.gumtree.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomerDetails {

	private String firstName;

	private String lastName;

	private String gender;

	private String birthDate;

	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}
}
