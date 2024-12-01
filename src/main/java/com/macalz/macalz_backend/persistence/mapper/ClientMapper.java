package com.macalz.macalz_backend.persistence.mapper;

import com.macalz.macalz_backend.domain.dto.ClientDTO;
import com.macalz.macalz_backend.persistence.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "date", target = "date")
    })
    ClientDTO toClientDTO(Client client);

    @InheritInverseConfiguration
    @Mapping(target = "purchases", ignore = true) // Ignorar la relación en el mapeo inverso
    Client toClient(ClientDTO clientDTO);
}
