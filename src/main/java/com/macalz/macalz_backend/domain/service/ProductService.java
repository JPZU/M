package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.ProductDTO;
import com.macalz.macalz_backend.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDTO> findById(long productId) {
        return productRepository.getById(productId);
    }

    public Optional<ProductDTO> findByName(String name) {
        return productRepository.getByName(name);
    }

    public ProductDTO save(ProductDTO productDTO) {
        return productRepository.save(productDTO);
    }

    public boolean delete(long productId) {
        return findById(productId).map(product -> {
            productRepository.deleteById(productId);
            return true;
        }).orElse(false);
    }


}
