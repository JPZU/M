package com.macalz.macalz_backend.domain.repository;


import com.macalz.macalz_backend.domain.dto.PaymentTypeDTO;

import java.util.List;

public interface PaymentTypeRepository {
    List<PaymentTypeDTO> getAll();
    PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO);
    void delete(int paymentTypeId);
}
