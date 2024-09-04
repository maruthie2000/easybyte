package com.nit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue( strategy=GenerationType.SEQUENCE)
	@Column(name = "customer_id")
	private int id;
	
	private String name;
	private String email;
	private String mobileNumber;
	private String pwd;
	private String role;
	@Column(name="create_Dt")
	private String createDt;
}
 
