package com.marcos.desenvolvimento.authapi.repositories;

import com.marcos.desenvolvimento.authapi.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserDTO, String>{

    UserDetails findByLogin(String login);

}
