package com.macalz.macalz_backend.domain.repository;

import com.macalz.macalz_backend.domain.dto.UserTypeDTO;

import java.util.List;

public interface USerTypeRepository {
    List<UserTypeDTO> getAll();
    UserTypeDTO save(UserTypeDTO userTypeDTO);
    void delete(int userTypeId);
}
