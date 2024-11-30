package com.macalz.macalz_backend.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
@Table(name = "taxes")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    private Integer taxId;
    @Column(length = 100)
    private String name;
    @Positive
    @Column(columnDefinition = "DECIMAL(5, 2) CHECK (rate > 0)")
    private Double rate;
//    Relation
//    Relation with purchase
    @OneToMany(mappedBy = "taxId")
    private List<Purchase> purchases;

    public Tax() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }
}
