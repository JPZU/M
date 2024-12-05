package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.ProductDTO;
import com.macalz.macalz_backend.domain.repository.ProductRepository;
import com.macalz.macalz_backend.persistence.crud.ProductCrudRepository;
import com.macalz.macalz_backend.persistence.entity.Product;
import com.macalz.macalz_backend.persistence.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductRepositoryImp implements ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAll() {
        Iterable<Product> products = productCrudRepository.findAll();
        return StreamSupport.stream(products.spliterator(), false)
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getById(long productId) {
        return productCrudRepository.findById(productId)
                .map(productMapper::toProductDTO);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product productEntity;

        // Si `productId` no es null, se trata de una actualización
        if (productDTO.getProductId() != null) {
            productEntity = productCrudRepository.findById(productDTO.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + productDTO.getProductId()));

            // Actualiza los valores del producto existente
            productEntity.setName(productDTO.getName());
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setStock(productDTO.getStock());
        } else {
            // Si `productId` es null, se trata de una creación
            productEntity = productMapper.toProduct(productDTO);
        }

        // Guarda el producto (ya sea creación o actualización)
        Product savedProduct = productCrudRepository.save(productEntity);

        // Devuelve el producto guardado como DTO
        return productMapper.toProductDTO(savedProduct);
    }


    @Override
    public void deleteById(long productId){
        productCrudRepository.deleteById(productId);
    }

    @Override
    public Optional<ProductDTO> getByName(String name) {
        List<Product> products = productCrudRepository.findByName(name);
        return products.stream()
                .findFirst()
                .map(productMapper::toProductDTO);
    }
}
