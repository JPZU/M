package com.macalz.macalz_backend.domain.repository;


import com.macalz.macalz_backend.domain.dto.TaxDTO;

import java.util.List;
import java.util.Optional;

public interface TaxRepository {
    List<TaxDTO> getAll();
    Optional<TaxDTO> getById(int id);
    TaxDTO save(TaxDTO taxDTO);
    void delete(int taxDTO);
}
