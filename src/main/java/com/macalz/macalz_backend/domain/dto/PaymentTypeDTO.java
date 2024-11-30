package com.macalz.macalz_backend.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PaymentTypeDTO {
    @NotNull(message = "Payment Type ID is required")
    private int paymentTypeId;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    private String name;
    public PaymentTypeDTO() {}
}
