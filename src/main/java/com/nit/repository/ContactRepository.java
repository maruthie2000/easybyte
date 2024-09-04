package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
}
