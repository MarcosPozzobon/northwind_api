package com.marcos.desenvolvimento.authapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_ids")
    private String supplierIds;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "standard_cost")
    private Double standardCost;

    @Column(name = "list_price")
    private Double listPrice;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "target_level")
    private Integer targetLevel;

    @Column(name = "quantity_per_unit")
    private String qtdPerUnit;

    @Column(name = "minimum_reorder_quantity")
    private int minimumReorderQuantity;

    @Column(name = "category")
    private String category;

    public ProductsModel(){

    }

    public ProductsModel(Long id, String supplierIds, String productCode, String productName, String description,
                         Double standardCost, Double listPrice, Integer reorderLevel, Integer targetLevel, String qtdPerUnit,
                         int minimumReorderQuantity, String category) {
        this.id = id;
        this.supplierIds = supplierIds;
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.standardCost = standardCost;
        this.listPrice = listPrice;
        this.reorderLevel = reorderLevel;
        this.targetLevel = targetLevel;
        this.qtdPerUnit = qtdPerUnit;
        this.minimumReorderQuantity = minimumReorderQuantity;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsModel that = (ProductsModel) o;
        return minimumReorderQuantity == that.minimumReorderQuantity && Objects.equals(id, that.id) && Objects.equals(supplierIds, that.supplierIds) && Objects.equals(productCode, that.productCode) && Objects.equals(productName, that.productName) && Objects.equals(description, that.description) && Objects.equals(standardCost, that.standardCost) && Objects.equals(listPrice, that.listPrice) && Objects.equals(reorderLevel, that.reorderLevel) && Objects.equals(targetLevel, that.targetLevel) && Objects.equals(qtdPerUnit, that.qtdPerUnit) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplierIds, productCode, productName, description, standardCost, listPrice, reorderLevel, targetLevel, qtdPerUnit, minimumReorderQuantity, category);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(String supplierIds) {
        this.supplierIds = supplierIds;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(Double standardCost) {
        this.standardCost = standardCost;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Integer getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Integer targetLevel) {
        this.targetLevel = targetLevel;
    }

    public String getQtdPerUnit() {
        return qtdPerUnit;
    }

    public void setQtdPerUnit(String qtdPerUnit) {
        this.qtdPerUnit = qtdPerUnit;
    }

    public int getMinimumReorderQuantity() {
        return minimumReorderQuantity;
    }

    public void setMinimumReorderQuantity(int minimumReorderQuantity) {
        this.minimumReorderQuantity = minimumReorderQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
