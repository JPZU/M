package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<PurchaseDTO> getById(long purchaseId);
    Optional<List<PurchaseDTO>> getByUserId(String userId);
    Optional<List<PurchaseDTO>> getByClientId(String clientId);
    Optional<List<PurchaseDTO>> getByPaymentTypeId(int paymentTypeId);
    PurchaseDTO save(PurchaseDTO purchase);
    void deleteById(long purchaseId);
}
