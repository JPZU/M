package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.PurchaseDTO;
import com.macalz.macalz_backend.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDTO> findAll() {
        return purchaseRepository.getAll();
    }

    public Optional<PurchaseDTO> findPurchaseById(long purchaseId) {
        return purchaseRepository.getById(purchaseId);
    }

    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        return purchaseRepository.save(purchaseDTO);
    }

    public boolean delete(long purchaseId) {
        return findPurchaseById(purchaseId)
                .map(purchaseDTO -> {
                    purchaseRepository.deleteById(purchaseId);
                    return true;
                }).orElse(false);
    }
}
