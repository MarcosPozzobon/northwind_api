package com.marcos.desenvolvimento.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import com.marcos.desenvolvimento.authapi.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@GetMapping("/{id}")
	ResponseEntity<CustomerModel> getCustomerByID(@PathVariable Long id){
		
		try {
            // Verifica se o funcionário com o ID fornecido existe
            if (repository.existsById(id)) {
                CustomerModel customer = repository.findById(id).get();
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
		
	}

}
