package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.PurchaseProductDTO;
import com.macalz.macalz_backend.domain.repository.PurchaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseProductService {

    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

    public List<PurchaseProductDTO> findAll() {
        return purchaseProductRepository.getAll();
    }

    public Optional<PurchaseProductDTO> findById(Long purchaseProductId) {
        return purchaseProductRepository.getById(purchaseProductId);
    }

    public PurchaseProductDTO save(PurchaseProductDTO purchaseProductDTO) {
        return purchaseProductRepository.save(purchaseProductDTO);
    }

    public boolean deleteById(Long purchaseProductId) {
        return findById(purchaseProductId)
                .map(purchaseProduct -> {
                    purchaseProductRepository.deleteById(purchaseProductId);
                    return true;
                }).orElse(false);
    }
}
