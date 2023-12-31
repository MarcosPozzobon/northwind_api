package com.marcos.desenvolvimento.authapi.repositories;

import com.marcos.desenvolvimento.authapi.models.SalesReportsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReportsModel, String> {

    @Query("SELECT s FROM SalesReportsModel s")
    List<SalesReportsModel> getAllAuthorizedInfo();

}
