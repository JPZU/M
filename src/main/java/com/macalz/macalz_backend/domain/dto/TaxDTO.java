package com.macalz.macalz_backend.domain.dto;

import jakarta.validation.constraints.*;

public class TaxDTO {
//    @NotNull(message = "Tax ID is required")
    private Integer taxId;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name must not exceed 100 character")
    private String name;

    @NotNull(message = "Rate is required")
    @Positive(message = "Rate must greater than 0")
    private double rate;

    public TaxDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }
}
