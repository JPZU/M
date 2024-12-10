package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.TaxDTO;
import com.macalz.macalz_backend.domain.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxService {
    @Autowired
    private TaxRepository taxRepository;

    public List<TaxDTO> findAll() {
        return taxRepository.getAll();
    }

    public Optional<TaxDTO> findTaxById(int taxId) {
        return taxRepository.getById(taxId);
    }

    public TaxDTO save(TaxDTO taxDTO) {
        return taxRepository.save(taxDTO);
    }
    public boolean deleteTaxById(int taxId) {
        return findTaxById(taxId)
                .map(taxDTO -> {
                    taxRepository.delete(taxId);
                    return true;
                }).orElse(false);
    }
}
