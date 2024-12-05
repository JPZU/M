package com.macalz.macalz_backend.domain.dto;

import jakarta.validation.constraints.*;

public class ProductDTO {
//    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name must not exceed 100 character")
    private String name;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be 0 or greater")
    private double price;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Stock must be 0 or greater")
    private int stock;

    public ProductDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
