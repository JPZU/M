package com.macalz.macalz_backend.persistence.crud;

import com.macalz.macalz_backend.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, String> {
}
