package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.PaymentTypeDTO;
import com.macalz.macalz_backend.domain.repository.PaymentTypeRepository;
import com.macalz.macalz_backend.persistence.crud.PaymentTypeCrudRepository;
import com.macalz.macalz_backend.persistence.entity.PaymentType;
import com.macalz.macalz_backend.persistence.mapper.PaymentTypeMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PaymentTypeRepositoryImp implements PaymentTypeRepository {

    @Autowired
    private PaymentTypeCrudRepository paymentTypeCrudRepository;

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PaymentTypeDTO> getAll(){
        Iterable<PaymentType> paymentTypes = paymentTypeCrudRepository.findAll();
        return StreamSupport.stream(paymentTypes.spliterator(), false)
                .map(paymentTypeMapper::toPaymentTypeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PaymentTypeDTO> getById(int paymentTypeId){
        return paymentTypeCrudRepository.findById(paymentTypeId)
                .map(paymentTypeMapper::toPaymentTypeDTO);
    }

    @Override
    public PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO){
        PaymentType paymentTypeEntity;

        if(paymentTypeDTO.getPaymentTypeId()!= null){
            paymentTypeEntity = paymentTypeCrudRepository.findById(paymentTypeDTO.getPaymentTypeId())
                    .orElseThrow(() -> new EntityNotFoundException("PaymentType not found"));
        }else{
            paymentTypeEntity = paymentTypeMapper.toPaymentType(paymentTypeDTO);
        }
        PaymentType savedPaymentType = paymentTypeCrudRepository.save(paymentTypeEntity);

        return paymentTypeMapper.toPaymentTypeDTO(savedPaymentType);
    }


    @Override
    public void delete(int paymentTypeId){
        paymentTypeCrudRepository.deleteById(paymentTypeId);
    }
}
