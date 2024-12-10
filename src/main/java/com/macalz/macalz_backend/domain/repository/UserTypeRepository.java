package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.UserTypeDTO;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository {
    List<UserTypeDTO> getAll();
    Optional<UserTypeDTO> getById(int id);
    UserTypeDTO save(UserTypeDTO userTypeDTO);
    void delete(int userTypeId);
}
