package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.AuthenticationDTO;
import com.marcos.desenvolvimento.authapi.models.LoginResponseDTO;
import com.marcos.desenvolvimento.authapi.models.RegisterDTO;
import com.marcos.desenvolvimento.authapi.models.UserDTO;
import com.marcos.desenvolvimento.authapi.repositories.UserRepository;
import com.marcos.desenvolvimento.authapi.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){

        var usernnamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernnamePassword);

        var token = tokenService.generateToken((UserDTO) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserDTO newUser = new UserDTO(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return  ResponseEntity.ok().build();
    }

}
