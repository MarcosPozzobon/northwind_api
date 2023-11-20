package com.marcos.desenvolvimento.authapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "invoices")
public class InvoiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "invoice_date")
    private Timestamp invoiceDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "shipping")
    private BigDecimal shipping;

    @Column(name = "amount_due")
    private BigDecimal amountDue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceModel that = (InvoiceModel) o;
        return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId) && Objects.equals(invoiceDate, that.invoiceDate) && Objects.equals(dueDate, that.dueDate) && Objects.equals(tax, that.tax) && Objects.equals(shipping, that.shipping) && Objects.equals(amountDue, that.amountDue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, invoiceDate, dueDate, tax, shipping, amountDue);
    }

    public InvoiceModel(){

    }

    public InvoiceModel(Long id, Long orderId, Timestamp invoiceDate, Timestamp dueDate, BigDecimal tax, BigDecimal shipping, BigDecimal amountDue) {
        this.id = id;
        this.orderId = orderId;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.tax = tax;
        this.shipping = shipping;
        this.amountDue = amountDue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }
}
