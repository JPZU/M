package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeCrudRepository extends CrudRepository<UserType, Integer> {
}
