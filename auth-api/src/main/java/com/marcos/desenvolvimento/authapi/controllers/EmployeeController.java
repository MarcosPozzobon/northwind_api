package com.marcos.desenvolvimento.authapi.controllers;
import java.util.Optional;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.marcos.desenvolvimento.authapi.models.EmployeeModel;
import com.marcos.desenvolvimento.authapi.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id) {
        try {
            // Verifica se o funcionário com o ID fornecido existe
            if (repository.existsById(id)) {
                EmployeeModel employee = repository.findById(id).get();
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @PostMapping("/save_new_employee")
    public ResponseEntity<?> saveNewEmployee(@RequestBody EmployeeModel newEmployee) {
        try {
            // Verifica se o funcionário já existe
            Optional<EmployeeModel> existingEmployee = repository.findByFirstNameAndLastNameAndAddressAndZipPostalCode(
                    newEmployee.getFirstName(), newEmployee.getLastName(),
                    newEmployee.getAddress(), newEmployee.getZipPostalCode()
            );
            // Verifica se o Optional existe e se há um funcionário com as mesmas informações
            if (existingEmployee.isPresent() &&
                    existingEmployee.get().getFirstName().equals(newEmployee.getFirstName()) &&
                    existingEmployee.get().getLastName().equals(newEmployee.getLastName()) &&
                    existingEmployee.get().getAddress().equals(newEmployee.getAddress()) &&
                    existingEmployee.get().getZipPostalCode().equals(newEmployee.getZipPostalCode())) {
                return ResponseEntity.badRequest().body("Employee with the same information already exists.");
            }
            // Se não houver conflitos, salva o novo funcionário
            EmployeeModel newEmployeeToSave = repository.save(newEmployee);
            return ResponseEntity.ok(newEmployeeToSave);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }

    // Método auxiliar para verificar se uma string é nula ou vazia
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    @DeleteMapping("/delete_employee/{id}")
	public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable Long id) {
	    try {
	        Optional<EmployeeModel> employee = repository.findById(id);
	        
	        if (employee.isPresent()) {
	            repository.deleteById(id);
	            return ResponseEntity.ok(employee.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(500).build();
	    }
	}
	@PutMapping("/update_employee/{id}")
    public ResponseEntity<EmployeeModel> updateEmployeeInfo(@PathVariable Long id, @RequestBody EmployeeModel newEmployeeFromRequest) {
        try {
        	//PROCURA PELO COLABORADOR E VERIFICA SE ELE EXISTE. CASO EXISTA, ELE PROCEDE NORMALMENTE COM O PROCESSO...
            Optional<EmployeeModel> optionalEmployee = repository.findById(id);

            if (optionalEmployee.isPresent()) {
                EmployeeModel existingEmployee = optionalEmployee.get();
                existingEmployee.setCompany(newEmployeeFromRequest.getCompany());
                existingEmployee.setFirstName(newEmployeeFromRequest.getFirstName());
                existingEmployee.setLastName(newEmployeeFromRequest.getLastName());
                existingEmployee.setEmailAddress(newEmployeeFromRequest.getEmailAddress());
                existingEmployee.setJobTitle(newEmployeeFromRequest.getJobTitle());
                existingEmployee.setBusinessPhone(newEmployeeFromRequest.getBusinessPhone());
                existingEmployee.setHomePhone(newEmployeeFromRequest.getHomePhone());
                existingEmployee.setMobilePhone(newEmployeeFromRequest.getMobilePhone());
                existingEmployee.setFaxNumber(newEmployeeFromRequest.getFaxNumber());
                existingEmployee.setAddress(newEmployeeFromRequest.getAddress());
                existingEmployee.setCity(newEmployeeFromRequest.getCity());
                existingEmployee.setStateProvince(newEmployeeFromRequest.getStateProvince());
                existingEmployee.setZipPostalCode(newEmployeeFromRequest.getZipPostalCode());
                existingEmployee.setCountryRegion(newEmployeeFromRequest.getCountryRegion());

                repository.save(existingEmployee);
                return ResponseEntity.ok(existingEmployee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
