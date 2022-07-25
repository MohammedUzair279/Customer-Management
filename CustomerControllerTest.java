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
		assertNull(customerController.getAllCustomers("uzair"));
		
	}
	
	@Test
	public void getCustomerByIdTest() {
		
		Optional<Customer> customers = Optional.of( new Customer());
		Mockito.<Optional<Customer>>when(customerRepository.findById(Mockito.anyLong())).thenReturn(customers);
		assertNull(customerController.getAllCustomers("uzair"));
		
	}
	
	@Test
	public void createCustomerTest() {
		
		Customer customers = new Customer();
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customers);
		assertNull(customerController.createCustomer(customers));
		
	}
	
	@Test
	public void updateCustomerTest() {
		Customer customer = new Customer();
		Optional<Customer> customers = Optional.of( new Customer());
		Mockito.<Optional<Customer>>when(customerRepository.findById(Mockito.anyLong())).thenReturn(customers);
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customers);
		assertNull(customerController.updateCustomer(1L, customer));
		
	}
	
	@Test
	public void deleteCustomerTest() {
		
		Mockito.doNothing().when(customerRepository).deleteById(Mockito.anyLong());
		assertNull(customerController.deleteCustomer(1L));
		
	}
	
	
	

}
