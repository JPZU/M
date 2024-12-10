package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserDTO> getAll();
    Optional<UserDTO> getById(String userId);
    UserDTO save(UserDTO userDTO);
    void delete(String userId);
}
