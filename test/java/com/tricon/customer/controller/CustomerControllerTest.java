package com.tricon.customer.controller;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.tricon.customer.model.Customer;
import com.tricon.customer.repository.CustomerRepository;

//@RunWith(junit.class)
public class CustomerControllerTest {
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerController customerController;
	
	@Before
	public void setUp() {
		customerRepository = Mockito.mock(CustomerRepository.class);
		customerController = Mockito.mock(CustomerController.class);
		customerController.customerRepository = customerRepository;
	}
	
	@Test
	public void getAllCustomersTest() {
		List<Customer> customers = new ArrayList<Customer>();
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		assertNull(customerController.getAllCustomers("uzaitr"));
		
	}
	
	@Test
	public void getCustomerByIdTest() {
		
		Optional<Customer> customers = Optional.of( new Customer());
		Mockito.<Optional<Customer>>when(customerRepository.findById(Mockito.anyLong())).thenReturn(customers);
		assertNull(customerController.getAllCustomers("uzaitr"));
		
	}
	

}
