package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.ProductDTO;
import com.macalz.macalz_backend.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock")
    })
    ProductDTO toProductDTO(Product product);

    @InheritInverseConfiguration
    @Mapping(target = "purchaseProducts", ignore = true) // Ignorar la relación en el mapeo inverso
    Product toProduct(ProductDTO productDTO);
}
