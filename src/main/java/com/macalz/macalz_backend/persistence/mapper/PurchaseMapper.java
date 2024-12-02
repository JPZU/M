package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.PurchaseDTO;
import com.macalz.macalz_backend.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ClientMapper.class,TaxMapper.class, PaymentTypeMapper.class}
)
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "purchaseId", target = "purchaseId"),
            @Mapping(source = "purchaseDate", target = "purchaseDate"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "clientId", target = "client"),
            @Mapping(source = "userId", target = "user"),
            @Mapping(source = "taxId", target = "tax"),
            @Mapping(source = "paymentType", target = "paymentType")
    })
    PurchaseDTO toPurchaseDTO(Purchase purchase);

    @InheritInverseConfiguration
    @Mapping(target = "purchaseProducts", ignore = true) // Ignorar la relación 1:N
    Purchase toPurchase(PurchaseDTO purchaseDTO);
}