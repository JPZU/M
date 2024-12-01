package com.macalz.macalz_backend.domain.repository;
import com.macalz.macalz_backend.domain.dto.ClientDTO;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<ClientDTO> getAll();
    Optional<ClientDTO> getById(String clientId);
    Optional<ClientDTO> getByName(String name);
    ClientDTO save(ClientDTO clientDTO);
    void delete(String clientId);
}

