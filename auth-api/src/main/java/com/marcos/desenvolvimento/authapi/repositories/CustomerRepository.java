package com.marcos.desenvolvimento.authapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{
	
	Optional<CustomerModel> findByUser(String firstName);

}
