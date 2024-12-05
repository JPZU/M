package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<PurchaseDTO> getById(long purchaseId);
    PurchaseDTO save(PurchaseDTO purchase);
    void deleteById(long purchaseId);
}
