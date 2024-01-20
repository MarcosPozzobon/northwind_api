package com.marcos.desenvolvimento.authapi.repositories;

import com.marcos.desenvolvimento.authapi.models.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsModel, Long > {

}
