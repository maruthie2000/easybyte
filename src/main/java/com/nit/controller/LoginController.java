package com.nit.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Customer;
import com.nit.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRespository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		Customer savedCustomer = null;
		ResponseEntity<String> response = null;
		try {
			String hashPwd = passwordEncoder.encode(customer.getPwd());

			customer.setPwd(hashPwd);
			customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
//	            savedCustomer = customerRepositor.save(customer);
			savedCustomer = customerRespository.save(customer);
			if (savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user details are successfully registered");
			}
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to " + ex.getMessage());
		}
		return response;
	}

	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Authentication authentication) {
		List<Customer> customers = customerRespository.findByEmail(authentication.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		} else {
			return null;
		}

	}

}
