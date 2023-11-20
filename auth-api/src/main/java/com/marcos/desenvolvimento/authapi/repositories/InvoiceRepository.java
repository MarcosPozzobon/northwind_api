package com.marcos.desenvolvimento.authapi.repositories;

import com.marcos.desenvolvimento.authapi.models.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {

    Optional<InvoiceModel> findByOrderId(Long orderId);

    Optional<InvoiceModel> deleteByOrderId(Long orderId);
}
