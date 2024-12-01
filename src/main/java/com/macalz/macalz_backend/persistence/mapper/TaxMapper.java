package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.TaxDTO;
import com.macalz.macalz_backend.persistence.entity.Tax;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TaxMapper {
    @Mappings({
            @Mapping(source = "taxId",  target = "taxId"),
            @Mapping(source = "name",  target = "name"),
            @Mapping(source = "rate",  target = "rate"),
    })
    TaxDTO toTaxDTO(Tax tax);

    @InheritInverseConfiguration
    @Mapping(target = "purchases", ignore = true) // Ignorar la relación 1:N
    Tax toTax(TaxDTO taxDTO);
}
