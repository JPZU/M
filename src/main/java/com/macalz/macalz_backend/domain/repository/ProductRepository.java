package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDTO> getAll();
    Optional<ProductDTO> getById(long productId);
    Optional<ProductDTO> getByName(String name);
    ProductDTO save(ProductDTO productDTO);
    void deleteById(long productId);
}


