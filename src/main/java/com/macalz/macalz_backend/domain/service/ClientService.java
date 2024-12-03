package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.ClientDTO;
import com.macalz.macalz_backend.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> findAll() {
        return clientRepository.getAll();
    }

    public Optional<ClientDTO> findById(String clientId) {
        return clientRepository.getById(clientId);
    }

    public Optional<ClientDTO> findByName(String name) {
        return clientRepository.getByName(name);
    }

    public ClientDTO save(ClientDTO clientDTO) {
        return clientRepository.save(clientDTO);
    }

    public boolean delete(String clientId) {
        return findById(clientId).map(client -> {
            clientRepository.delete(clientId);
            return true;
        }).orElse(false);
    }




}
