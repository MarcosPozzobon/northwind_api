package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import com.marcos.desenvolvimento.authapi.models.PurchaseOrderModel;
import com.marcos.desenvolvimento.authapi.repositories.PurchaseOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("/purchases") // IMPLEMENTAR AUTORIZACAO AQUI DEPOIS
public class PurchaseOrderAuthorizedPersonRequestsOnly {

    /*
    *
    * CLASSE EXTREMAMENTE IMPORTANTE. VÁRIAS VALIDAÇÕES SERÃO ADICIONADAS A ELA MAIS PRA FRENTE. POR ENQUANTO, APENAS TESTANDO
    * AS REQUSIÇÕES BÁSICAS...
    *
    *
    *
    * */

    @Autowired
    PurchaseOrderRepository repository;

    @GetMapping("/purchase_orders_info/{id}")
    public ResponseEntity<?> getPurchaseOrderById(@PathVariable Long id) {
        try {
            Optional<PurchaseOrderModel> existingPurchaseOptional = repository.findById(id);
            if (existingPurchaseOptional.isPresent()) {
                PurchaseOrderModel existingPurchase = existingPurchaseOptional.get();
                return ResponseEntity.ok(existingPurchase);
            } else {
                return ResponseEntity.status(404).body("Purchase order not found.");
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving purchase order information.");
        }
    }

    @PostMapping("/create_new_purchase_order")
    public ResponseEntity<?> createNewPurchaseOrder(@RequestBody PurchaseOrderModel purchase) {
        try {
            // IMPLEMENTAR VALIDACAO MAIS PRA FRENTE... por enquanto apenas testando as requsicoes basicas...
            PurchaseOrderModel newCreatedPurchase = repository.save(purchase);
            return ResponseEntity.ok(newCreatedPurchase);
        } catch (DataIntegrityViolationException | ConstraintViolationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data or data integrity violation.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }

    @DeleteMapping("/delete_purchase_order/{id}")
    public ResponseEntity<PurchaseOrderModel> deletePurchaseOrderById(@PathVariable Long id){
        try{
            Optional<PurchaseOrderModel> order = repository.findById(id);
            if(order.isPresent()){
                repository.deleteById(id);
                return ResponseEntity.ok(order.get());
            }
            return ResponseEntity.notFound().build();
        }catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}

