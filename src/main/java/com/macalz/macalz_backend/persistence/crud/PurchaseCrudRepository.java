package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Long> {
}
