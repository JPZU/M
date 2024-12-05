package com.macalz.macalz_backend.domain.repository;


import com.macalz.macalz_backend.domain.dto.PaymentTypeDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentTypeRepository {
    List<PaymentTypeDTO> getAll();
    Optional<PaymentTypeDTO> getById(int paymentTypeId);
    PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO);
    void delete(int paymentTypeId);
}
