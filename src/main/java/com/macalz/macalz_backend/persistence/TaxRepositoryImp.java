package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.TaxDTO;
import com.macalz.macalz_backend.domain.repository.TaxRepository;
import com.macalz.macalz_backend.persistence.crud.TaxCrudRepository;
import com.macalz.macalz_backend.persistence.entity.Tax;
import com.macalz.macalz_backend.persistence.mapper.TaxMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TaxRepositoryImp implements TaxRepository {

    @Autowired
    private TaxCrudRepository taxCrudRepository;

    @Autowired
    private TaxMapper taxMapper;

    @Override
    public List<TaxDTO> getAll(){
        Iterable<Tax> taxes = taxCrudRepository.findAll();
        return StreamSupport.stream(taxes.spliterator(), false)
                .map(taxMapper::toTaxDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaxDTO> getById(int taxId){
        return taxCrudRepository.findById(taxId)
                .map(taxMapper::toTaxDTO);
    }

    @Override
    public TaxDTO save(TaxDTO taxDTO){
        Tax taxEntity;

        if(taxDTO.getTaxId() != null){
            taxEntity = taxCrudRepository.findById(taxDTO.getTaxId())
                    .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
            taxEntity.setName(taxDTO.getName());
            taxEntity.setRate(taxDTO.getRate());
        }else{
            taxEntity = taxMapper.toTax(taxDTO);
        }

        Tax savedTax = taxCrudRepository.save(taxEntity);

        return taxMapper.toTaxDTO(savedTax);
    }

    @Override
    public void delete(int taxId){
        taxCrudRepository.deleteById(taxId);
    }
}
