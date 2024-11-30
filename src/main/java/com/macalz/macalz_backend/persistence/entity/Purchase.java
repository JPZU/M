package com.macalz.macalz_backend.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long purchaseId;
    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;
    @Column(columnDefinition = "CHECK (discount BETWEEN 0 AND 100)")
    private Double discount;

//    Relation
//    Relation with Client N:1
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

//    Relation with User N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

//    Relation with Tax N:1
    @ManyToOne
    @JoinColumn(name = "tax_id")
    private Tax taxId;

//    Relation with PaymentType N:1
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

//    Relation with purchaseProduct 1:N
    @OneToMany(mappedBy = "purchaseId")
    private List<PurchaseProduct> purchaseProducts;

    public Purchase() {}

    public List<PurchaseProduct> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void setPurchaseProducts(List<PurchaseProduct> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Tax getTaxId() {
        return taxId;
    }

    public void setTaxId(Tax taxId) {
        this.taxId = taxId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}

