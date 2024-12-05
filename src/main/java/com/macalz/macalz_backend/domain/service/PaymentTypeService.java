package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.PaymentTypeDTO;
import com.macalz.macalz_backend.domain.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    public List<PaymentTypeDTO> findAll() {
        return paymentTypeRepository.getAll();
    }

    public Optional<PaymentTypeDTO> findById(int paymentTypeId) {
        return paymentTypeRepository.getById(paymentTypeId);
    }

    public PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO) {
        return paymentTypeRepository.save(paymentTypeDTO);
    }

    public boolean delete(int paymentTypeId){
        return  findById(paymentTypeId)
                .map(paymentType -> {
                    paymentTypeRepository.delete(paymentTypeId);
                    return true;
                }).orElse(false);
    }
}
