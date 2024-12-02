package com.macalz.macalz_backend.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public class PurchaseDTO {
    @NotNull(message = "Purchase ID is required")
    private long purchaseId;

    @NotNull(message = "Date is required")
    private LocalDateTime purchaseDate;

    @PositiveOrZero(message = "Discount must be 0 or greater")
    @Max(value = 100, message = "Discount cannot exceed 100")
    private double discount;

    @NotNull(message = "User ID is required")
    private UserDTO user;
    @NotNull(message = "Client ID is required")
    private ClientDTO client;

    @NotNull(message = "Tax ID is required")
    private TaxDTO tax;

    @NotNull(message = "Payment type ID is required")
    private PaymentTypeDTO paymentType;

    public PurchaseDTO() {}

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public PaymentTypeDTO getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeDTO paymentType) {
        this.paymentType = paymentType;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public TaxDTO getTax() {
        return tax;
    }

    public void setTax(TaxDTO tax) {
        this.tax = tax;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
