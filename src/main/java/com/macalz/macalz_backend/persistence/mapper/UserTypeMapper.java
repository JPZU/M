package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.UserTypeDTO;
import com.macalz.macalz_backend.persistence.entity.UserType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {

    @Mapping(source = "userTypeId", target = "userTypeId")
    @Mapping(source = "name", target = "name")
    UserTypeDTO toUserTypeDTO(UserType userType);

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true) // Ignorar la relación 1:N con User en el mapeo inverso
    UserType toUserType(UserTypeDTO userTypeDTO);
}