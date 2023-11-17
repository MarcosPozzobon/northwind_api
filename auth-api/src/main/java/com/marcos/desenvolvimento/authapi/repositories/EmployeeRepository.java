package com.marcos.desenvolvimento.authapi.repositories;

import java.util.Optional;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.desenvolvimento.authapi.models.EmployeeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

	Optional<EmployeeModel> findByFirstNameAndLastNameAndAddressAndZipPostalCode(
			String firstName, String lastName, String address, String zipPostalCode
	);

}
