package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.PurchaseProductDTO;
import com.macalz.macalz_backend.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, PurchaseMapper.class})
public interface PurchaseProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "productId", target = "product"),
            @Mapping(source = "purchaseId", target = "purchase")
    })
    PurchaseProductDTO toPurchaseProductDTO(PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mapping(target = "purchaseId", ignore = true) // Ignorar la relación inversa si no es necesaria
    PurchaseProduct toPurchaseProduct(PurchaseProductDTO purchaseProductDTO);
}
