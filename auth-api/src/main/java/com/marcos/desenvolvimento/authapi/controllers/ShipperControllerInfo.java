package com.marcos.desenvolvimento.authapi.controllers;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import com.marcos.desenvolvimento.authapi.models.ShipperModel;
import com.marcos.desenvolvimento.authapi.repositories.ShipperRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shippers")
public class ShipperControllerInfo {

    @Autowired
    ShipperRepository repository;

    @GetMapping("/{id}")
    ResponseEntity<ShipperModel> getShipperById(@PathVariable Long id){
        try {
            // Verifica se o funcionário com o ID fornecido existe
            if (repository.existsById(id)) {
                ShipperModel shipper = repository.findById(id).get();
                return ResponseEntity.ok(shipper);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }
    @PostMapping("/save_new_shipper")
    public ResponseEntity<?> saveNewShipper(@RequestBody ShipperModel newShipper) {
        try {
            Optional<ShipperModel> existingShipper = repository.findByCompanyAndLocalizationAndStateProvince(
                    newShipper.getCompany(), newShipper.getLocalization(),
                    newShipper.getState_province()
            );
            // Verifica se o Optional existe e se há um funcionário com as mesmas informações
            if (existingShipper.isPresent() &&
                    existingShipper.get().getCompany().equals(newShipper.getCompany()) &&
                    existingShipper.get().getLocalization().equals(newShipper.getLocalization()) &&
                    existingShipper.get().getState_province().equals(newShipper.getState_province()))
                     {
                return ResponseEntity.badRequest().body("Shipper with the same information already exists.");
            }
            // Se não houver conflitos, salva o novo funcionário
            ShipperModel newShipperToSave = repository.save(newShipper);
            return ResponseEntity.ok(newShipperToSave);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Check your request body.");
        }
    }
}
