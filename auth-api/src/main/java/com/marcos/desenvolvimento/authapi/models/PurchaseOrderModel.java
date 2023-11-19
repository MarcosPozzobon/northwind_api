package com.marcos.desenvolvimento.authapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "purchase_orders")
public class PurchaseOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_id")
    private Long supplierId;


    @Column(name = "created_by")
    private Long createdBy;


    @Column(name = "submitted_date")
    private Timestamp submittedDate;


    @Column(name = "creation_date")
    private Timestamp creationDate;


    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "expected_date")
    private Timestamp excpectedDate;

    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    @Column(name = "taxes")
    private Double taxes;


    @Column(name = "payment_date")
    private Timestamp paymentDate;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;


    @Column(name = "payment_method")
    private String paymentMethod;

    private String notes;

    @Column(name = "approved_by")
    private Integer approvedBy;

    @Column(name = "approved_date")
    private Timestamp approvedDate;

    @Column(name = "submitted_by")
    private Long submittedBy;

   public PurchaseOrderModel(){
       
   }

    public PurchaseOrderModel(Long id, Long supplierId, Long createdBy, Timestamp submittedDate, Timestamp creationDate, Long statusId, Timestamp excpectedDate, BigDecimal shippingFee, Double taxes, Timestamp paymentDate, BigDecimal paymentAmount, String paymentMethod, String notes, Integer approvedBy, Timestamp approvedDate, Long submittedBy) {
        this.id = id;
        this.supplierId = supplierId;
        this.createdBy = createdBy;
        this.submittedDate = submittedDate;
        this.creationDate = creationDate;
        this.statusId = statusId;
        this.excpectedDate = excpectedDate;
        this.shippingFee = shippingFee;
        this.taxes = taxes;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.notes = notes;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.submittedBy = submittedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Timestamp submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Timestamp getExcpectedDate() {
        return excpectedDate;
    }

    public void setExcpectedDate(Timestamp excpectedDate) {
        this.excpectedDate = excpectedDate;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Long getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Long submittedBy) {
        this.submittedBy = submittedBy;
    }
}
