package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.PurchaseProductDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseProductRepository {

    List<PurchaseProductDTO> getAll();
    Optional<PurchaseProductDTO> getById(long id);
    List<PurchaseProductDTO> getByPurchaseId(long purchaseId);
    PurchaseProductDTO save(PurchaseProductDTO purchaseProductDTO);
    void deleteById(long id);
}
