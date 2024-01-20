package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.SalesReportsModel;
import com.marcos.desenvolvimento.authapi.repositories.SalesReportRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesReportController {

    @Autowired
    SalesReportRepository repository;

    @GetMapping("/get_authorized_sales_information")
    public ResponseEntity<?> returnAllAuthorizedInfoByRequest() {
        try {
            List<SalesReportsModel> authorizedInformation = repository.getAllAuthorizedInfo();
            return ResponseEntity.ok(authorizedInformation);
        } catch (Exception e) {
            ResponseEntity<String> body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while accessing data. You are probably not allowed to do that.");
            return body;
        }
    }

    @GetMapping("/TEST")

    public String test(){
        return "test endpoint is working.";
    }

}
