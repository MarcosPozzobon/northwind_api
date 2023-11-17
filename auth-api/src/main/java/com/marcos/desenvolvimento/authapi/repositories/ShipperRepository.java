package com.marcos.desenvolvimento.authapi.repositories;

import com.marcos.desenvolvimento.authapi.models.CustomerModel;
import com.marcos.desenvolvimento.authapi.models.ShipperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipperRepository extends JpaRepository<ShipperModel, Long> {

    Optional<ShipperModel> findByCompanyAndLocalizationAndStateProvince(
            String company, String localization, String state_province);

}
