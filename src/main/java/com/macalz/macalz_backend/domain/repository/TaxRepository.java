package com.macalz.macalz_backend.domain.repository;


import com.macalz.macalz_backend.domain.dto.TaxDTO;

import java.util.List;

public interface TaxRepository {
    List<TaxDTO> getAll();
    TaxDTO save(TaxDTO taxDTO);
    void delete(TaxDTO taxDTO);
}
