package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.EmployeeModel;
import com.marcos.desenvolvimento.authapi.models.InvoiceModel;
import com.marcos.desenvolvimento.authapi.repositories.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/invoices") //http://localhost:8080/invoices/12
public class InvoiceController {

    @Autowired
    InvoiceRepository repository;

    //broken
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceModel> getInvoiceOrderByID(@PathVariable Long id) {
        Optional<InvoiceModel> existingPurchaseOrder  = repository.findById(id);
        //Optional<InvoiceModel> existingPurchaseOrder = repository.findByOrderId(orderId);
        if(existingPurchaseOrder.isPresent()){
            InvoiceModel invoiceOrder = existingPurchaseOrder.get();
            return ResponseEntity.ok(invoiceOrder);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/save_new_invoice_order")
    public ResponseEntity<?> saveNewInvoiceOrder(@RequestBody InvoiceModel newInvoice) {
        try {
            Optional<InvoiceModel> existingInvoiceOrder = repository.findById(newInvoice.getId());
            if (existingInvoiceOrder.isPresent() &&
                    existingInvoiceOrder.get().getOrderId().equals(newInvoice.getOrderId()) &&
                    existingInvoiceOrder.get().getId().equals(newInvoice.getId())) {
                return ResponseEntity.badRequest().body("Invoice Order with the same ID already exists.");
            }
            InvoiceModel newInvoiceOrderToSave = repository.save(newInvoice);
            return ResponseEntity.ok(newInvoiceOrderToSave);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }

    @Transactional
    @DeleteMapping("/delete_invoice_order/{orderId}")
    public ResponseEntity<InvoiceModel> deleteInvoiceOrderByID(@PathVariable Long orderId){
        Optional<InvoiceModel> existingInvoiceOrder = repository.findByOrderId(orderId);
        if(existingInvoiceOrder.isPresent()){
            repository.deleteByOrderId(orderId);
            return ResponseEntity.ok(existingInvoiceOrder.get());
        }
        return ResponseEntity.status(404).build();
    }
}
