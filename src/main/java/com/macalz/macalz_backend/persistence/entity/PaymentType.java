package com.macalz.macalz_backend.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment_types")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private Integer paymentTypeId;
    @Column(nullable = false, length = 50)
    private String name;
//    Relation
//    Relation with purchase
    @OneToMany(mappedBy = "paymentType")
    private List<Purchase> purchases;

    public PaymentType(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
