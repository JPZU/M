package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {
    
}
