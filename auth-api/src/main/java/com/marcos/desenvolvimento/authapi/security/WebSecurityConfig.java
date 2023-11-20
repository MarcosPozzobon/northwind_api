package com.marcos.desenvolvimento.authapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String ROTAS_PERMITIDAS = "/customer/{id}";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .formLogin().disable()
                .authorizeRequests()
                .requestMatchers(ROTAS_PERMITIDAS).permitAll() // Permite acessar as rotas especificadas sem autenticação
                .anyRequest().authenticated(); // Exige autenticação para outras rotas não especificadas

        return httpSecurity.build();
    }
}

