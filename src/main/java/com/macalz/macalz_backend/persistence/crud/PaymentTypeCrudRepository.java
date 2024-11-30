package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.PaymentType;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTypeCrudRepository extends CrudRepository<PaymentType, Integer> {
}
