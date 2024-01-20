package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import com.marcos.desenvolvimento.authapi.models.ProductsModel;
import com.marcos.desenvolvimento.authapi.repositories.ProductsRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<ProductsModel> getProductByID(@PathVariable Long id){
        try {
            // Verifica se o produto com o ID fornecido existe
            if (repository.existsById(id)) {
                ProductsModel product = repository.findById(id).get();
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/cep_teste")
    public String saveNewProduct() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://viacep.com.br/ws/01001000/json/"))
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
