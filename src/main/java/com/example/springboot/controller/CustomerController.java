package com.example.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springboot.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.model.Customer;
import com.example.springboot.repository.CustomerRepository;

import javax.persistence.PostRemove;


@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}

	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer){
		return customerRepository.save(customer);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer doesn't exist in Database"));
		return ResponseEntity.ok(customer);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer ){
		Customer newCustomer = customerRepository.findById( id ).orElseThrow(() -> new ResourceNotFound("Customer doesn't exist"));
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setEmailId(customer.getEmailId());
		newCustomer.setAccountBalance(customer.getAccountBalance());

		Customer postedCustomer = customerRepository.save(newCustomer);
		return ResponseEntity.ok(postedCustomer);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id ){
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Customer not found"));
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
