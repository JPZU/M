package com.macalz.macalz_backend.persistence;


import com.macalz.macalz_backend.domain.dto.PurchaseProductDTO;
import com.macalz.macalz_backend.domain.repository.PurchaseProductRepository;
import com.macalz.macalz_backend.persistence.crud.PurchaseProductCrudRepository;
import com.macalz.macalz_backend.persistence.entity.PurchaseProduct;
import com.macalz.macalz_backend.persistence.mapper.PurchaseProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PurchaseProductRepositoryImp implements PurchaseProductRepository {

    @Autowired
    private PurchaseProductCrudRepository purchaseProductCrudRepository;

    @Autowired
    private PurchaseProductMapper purchaseProductMapper;

    @Override
    public List<PurchaseProductDTO> getAll(){
        Iterable<PurchaseProduct> purchaseProducts = purchaseProductCrudRepository.findAll();
        return StreamSupport.stream(purchaseProducts.spliterator(), false)
                .map(purchaseProductMapper::toPurchaseProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseProductDTO> getById(long id){
        return purchaseProductCrudRepository.findById(id)
                .map(purchaseProductMapper::toPurchaseProductDTO);
    }

    @Override
    public PurchaseProductDTO save(PurchaseProductDTO purchaseProductDTO){
        PurchaseProduct purchaseProductEntity = purchaseProductMapper.toPurchaseProduct(purchaseProductDTO);
        PurchaseProduct savedPurchaseProduct = purchaseProductCrudRepository.save(purchaseProductEntity);
        return purchaseProductMapper.toPurchaseProductDTO(savedPurchaseProduct);
    }

    @Override
    public void deleteById(long id){
        purchaseProductCrudRepository.deleteById(id);
    }
}
