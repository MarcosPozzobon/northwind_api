package com.marcos.desenvolvimento.authapi.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "shippers")
public class ShipperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String localization;

    @Column(name = "state_province")
    private String stateProvince;

    public ShipperModel(){

    }

    public ShipperModel(Long id, String company, String localization, String state_province) {
        this.id = id;
        this.company = company;
        this.localization = localization;
        this.stateProvince = state_province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getState_province() {
        return stateProvince;
    }

    public void setState_province(String state_province) {
        this.stateProvince = state_province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipperModel that = (ShipperModel) o;
        return Objects.equals(id, that.id) && Objects.equals(company, that.company) && Objects.equals(localization, that.localization) && Objects.equals(stateProvince, that.stateProvince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, localization, stateProvince);
    }
}
