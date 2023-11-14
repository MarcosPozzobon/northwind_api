package com.marcos.desenvolvimento.authapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.desenvolvimento.authapi.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
	Optional<EmployeeModel> findByUser(String userName);
	
}
