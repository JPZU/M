package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.PurchaseProduct;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseProductCrudRepository extends CrudRepository<PurchaseProduct, Long> {
}
