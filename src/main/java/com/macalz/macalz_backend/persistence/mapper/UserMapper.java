package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.UserDTO;
import com.macalz.macalz_backend.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserTypeMapper.class})
public interface UserMapper {
    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "userType", target = "userType"),
    })
    UserDTO toUserDTO(User user);

    @InheritInverseConfiguration
    User toUser(UserDTO userDTO);
}
