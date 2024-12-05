package com.macalz.macalz_backend.persistence;


import com.macalz.macalz_backend.domain.dto.PurchaseProductDTO;
import com.macalz.macalz_backend.domain.repository.PurchaseProductRepository;
import com.macalz.macalz_backend.persistence.crud.PurchaseProductCrudRepository;
import com.macalz.macalz_backend.persistence.entity.Product;
import com.macalz.macalz_backend.persistence.entity.Purchase;
import com.macalz.macalz_backend.persistence.entity.PurchaseProduct;
import com.macalz.macalz_backend.persistence.mapper.PurchaseProductMapper;
import jakarta.persistence.EntityNotFoundException;
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
    public PurchaseProductDTO save(PurchaseProductDTO purchaseProductDTO) {
        PurchaseProduct purchaseProductEntity;

        if (purchaseProductDTO.getId() != null) {
            purchaseProductEntity = purchaseProductCrudRepository.findById(purchaseProductDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("PurchaseProduct no encontrado con ID: " + purchaseProductDTO.getId()));

            // Actualizar cantidad
            purchaseProductEntity.setQuantity(purchaseProductDTO.getQuantity());

            // Actualizar relaciones si están presentes
            if (purchaseProductDTO.getProduct() != null) {
                Product product = new Product();
                product.setProductId(purchaseProductDTO.getProduct().getProductId());
                purchaseProductEntity.setProductId(product);
            }

            if (purchaseProductDTO.getPurchase() != null) {
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(purchaseProductDTO.getPurchase().getPurchaseId());
                purchaseProductEntity.setPurchaseId(purchase);
            }
        } else {
            // Crear nueva entidad
            purchaseProductEntity = new PurchaseProduct();
            purchaseProductEntity.setQuantity(purchaseProductDTO.getQuantity());

            if (purchaseProductDTO.getProduct() != null) {
                Product product = new Product();
                product.setProductId(purchaseProductDTO.getProduct().getProductId());
                purchaseProductEntity.setProductId(product);
            }

            if (purchaseProductDTO.getPurchase() != null) {
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(purchaseProductDTO.getPurchase().getPurchaseId());
                purchaseProductEntity.setPurchaseId(purchase);
            }
        }

        // Guardar entidad en la base de datos
        PurchaseProduct savedPurchaseProduct = purchaseProductCrudRepository.save(purchaseProductEntity);

        // Convertir la entidad guardada a DTO y devolverla
        return purchaseProductMapper.toPurchaseProductDTO(savedPurchaseProduct);
    }

    @Override
    public void deleteById(long id){
        purchaseProductCrudRepository.deleteById(id);
    }
}
