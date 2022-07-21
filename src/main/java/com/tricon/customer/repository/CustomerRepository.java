package com.tricon.customer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tricon.customer.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
