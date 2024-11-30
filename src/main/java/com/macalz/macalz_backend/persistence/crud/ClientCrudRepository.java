package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, String> {
}
