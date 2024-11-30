package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.Tax;
import org.springframework.data.repository.CrudRepository;

public interface TaxCrudRepository extends CrudRepository<Tax, Integer> {
}
