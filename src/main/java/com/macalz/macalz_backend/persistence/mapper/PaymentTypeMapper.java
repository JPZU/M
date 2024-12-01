package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.PaymentTypeDTO;
import com.macalz.macalz_backend.persistence.entity.PaymentType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper {

    @Mappings({
            @Mapping(source = "paymentTypeId", target = "paymentTypeId"),
            @Mapping(source = "name", target = "name")
    })
    PaymentTypeDTO toPaymentTypeDTO(PaymentType paymentType);

    @InheritInverseConfiguration
    @Mapping(target = "purchases", ignore = true) // Ignorar la relación en el mapeo inverso
    PaymentType toPaymentType(PaymentTypeDTO paymentTypeDTO);
}
