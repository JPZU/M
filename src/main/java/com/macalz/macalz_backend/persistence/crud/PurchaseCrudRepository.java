package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Long> {
}
