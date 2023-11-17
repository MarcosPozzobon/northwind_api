package com.marcos.desenvolvimento.authapi.repositories;

import java.util.Optional;

import com.marcos.desenvolvimento.authapi.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

	Optional<CustomerModel> findByFirstNameAndLastNameAndAddressAndZipPostalCode(
			String firstName, String lastName, String address, String zipPostalCode
	);

}
