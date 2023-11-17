package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import com.marcos.desenvolvimento.authapi.repositories.CustomerRepository;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
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
    @PostMapping("/save_new_customer")
    public ResponseEntity<?> saveNewCustomer(@RequestBody CustomerModel newCustomer) {
        try {
            Optional<CustomerModel> existingCustomer = repository.findByFirstNameAndLastNameAndAddressAndZipPostalCode(
                    newCustomer.getFirstName(), newCustomer.getLastName(),
                    newCustomer.getAddress(), newCustomer.getZipPostalCode()
            );
            // Verifica se o Optional existe e se há um funcionário com as mesmas informações
            if (existingCustomer.isPresent() &&
                    existingCustomer.get().getFirstName().equals(newCustomer.getFirstName()) &&
                    existingCustomer.get().getLastName().equals(newCustomer.getLastName()) &&
                    existingCustomer.get().getAddress().equals(newCustomer.getAddress()) &&
                    existingCustomer.get().getZipPostalCode().equals(newCustomer.getZipPostalCode())) {
                return ResponseEntity.badRequest().body("Customer with the same information already exists.");
            }
            // Se não houver conflitos, salva o novo funcionário
            CustomerModel newCustomerToSave = repository.save(newCustomer);
            return ResponseEntity.ok(newCustomerToSave);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Check your request body.");
        }
    }
    @DeleteMapping("/delete_customer/{id}")
    public ResponseEntity<CustomerModel> deleteCustomer(@PathVariable Long id){
        try{
            Optional<CustomerModel> customer = repository.findById(id);
            if(customer.isPresent()){
                repository.deleteById(id);
                return ResponseEntity.ok(customer.get());
            }
            return ResponseEntity.notFound().build();
        }catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }
    @PutMapping("/update_customer/{id}")
    public ResponseEntity<?> updateCustomerInfo(@PathVariable Long id, @RequestBody CustomerModel newCustomerFromRequest) {
        try {
            Optional<CustomerModel> optionalCustomer = repository.findById(id);

            if (optionalCustomer.isPresent()) {
                CustomerModel existingCustomer = optionalCustomer.get();
                existingCustomer.setFirstName(newCustomerFromRequest.getFirstName());
                existingCustomer.setLastName(newCustomerFromRequest.getLastName());
                existingCustomer.setEmailAddress(newCustomerFromRequest.getEmailAddress());
                existingCustomer.setJobTitle(newCustomerFromRequest.getJobTitle());
                existingCustomer.setBusinessPhone(newCustomerFromRequest.getBusinessPhone());
                existingCustomer.setHomePhone(newCustomerFromRequest.getHomePhone());
                existingCustomer.setMobilePhone(newCustomerFromRequest.getMobilePhone());
                existingCustomer.setFaxNumber(newCustomerFromRequest.getFaxNumber());
                existingCustomer.setAddress(newCustomerFromRequest.getAddress());
                existingCustomer.setCity(newCustomerFromRequest.getCity());
                existingCustomer.setStateProvince(newCustomerFromRequest.getStateProvince());
                existingCustomer.setZipPostalCode(newCustomerFromRequest.getZipPostalCode());
                existingCustomer.setCountryRegion(newCustomerFromRequest.getCountryRegion());

                CustomerModel updatedCustomer = repository.save(existingCustomer);
                return ResponseEntity.ok(updatedCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating customer: " + e.getMessage());
        }
    }
}
