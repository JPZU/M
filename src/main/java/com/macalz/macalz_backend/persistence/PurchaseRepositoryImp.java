package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.PurchaseDTO;
import com.macalz.macalz_backend.domain.repository.PurchaseRepository;
import com.macalz.macalz_backend.persistence.crud.PurchaseCrudRepository;
import com.macalz.macalz_backend.persistence.entity.PaymentType;
import com.macalz.macalz_backend.persistence.entity.Purchase;
import com.macalz.macalz_backend.persistence.mapper.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PurchaseRepositoryImp implements PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaxMapper taxMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PurchaseDTO> getAll() {
        Iterable<Purchase> purchases = purchaseCrudRepository.findAll();
        return StreamSupport.stream(purchases.spliterator(), false)
                .map(purchaseMapper::toPurchaseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseDTO> getById(long purchaseId) {
        return purchaseCrudRepository.findById(purchaseId)
                .map(purchaseMapper::toPurchaseDTO);
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchaseEntity;

        if (purchaseDTO.getPurchaseId() != null) {
            // Actualización de una compra existente
            purchaseEntity = purchaseCrudRepository.findById(purchaseDTO.getPurchaseId())
                    .orElseThrow(() -> new EntityNotFoundException("Purchase no encontrado con ID: " + purchaseDTO.getPurchaseId()));

            // Actualiza los campos necesarios
            purchaseEntity.setPurchaseDate(purchaseDTO.getPurchaseDate());
            purchaseEntity.setDiscount(purchaseDTO.getDiscount());
            purchaseEntity.setClientId(clientMapper.toClient(purchaseDTO.getClient()));
            purchaseEntity.setUserId(userMapper.toUser(purchaseDTO.getUser()));
            purchaseEntity.setTaxId(taxMapper.toTax(purchaseDTO.getTax()));
            purchaseEntity.setPaymentType(paymentTypeMapper.toPaymentType(purchaseDTO.getPaymentType()));
        } else {
            // Creación de una nueva compra
            purchaseEntity = purchaseMapper.toPurchase(purchaseDTO);
        }

        // Guarda la entidad en la base de datos
        Purchase savedPurchase = purchaseCrudRepository.save(purchaseEntity);

        // Devuelve la entidad guardada como DTO
        return purchaseMapper.toPurchaseDTO(savedPurchase);
    }


    @Override
    public void deleteById(long purchaseId){
        purchaseCrudRepository.deleteById(purchaseId);
    }

}
