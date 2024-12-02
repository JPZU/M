package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.ClientDTO;
import com.macalz.macalz_backend.domain.repository.ClientRepository;
import com.macalz.macalz_backend.persistence.entity.Client;
import com.macalz.macalz_backend.persistence.crud.ClientCrudRepository;
import com.macalz.macalz_backend.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ClientRepositoryImp implements ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAll() {
        Iterable<Client> clients = clientCrudRepository.findAll();
        return StreamSupport.stream(clients.spliterator(), false)
                .map(clientMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientDTO> getById(String clientId) {
        return clientCrudRepository.findById(clientId)
                .map(clientMapper::toClientDTO); // Mapea la entidad al DTO
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client clientEntity = clientMapper.toClient(clientDTO); // Mapeo inverso DTO -> Entidad
        Client savedClient = clientCrudRepository.save(clientEntity); // Guarda en la base
        return clientMapper.toClientDTO(savedClient); // Mapea Entidad -> DTO
    }

    @Override
    public void delete(String clientId) {
        clientCrudRepository.deleteById(clientId);
    }

    @Override
    public Optional<ClientDTO> getByName(String name) {
        // Utilizamos el método personalizado definido en ClientCrudRepository
        List<Client> clients = clientCrudRepository.findByName(name);
        // Mapear el primer cliente encontrado a DTO, o devolver un Optional vacío
        return clients.stream()
                .findFirst() // Tomar el primero (si existe)
                .map(clientMapper::toClientDTO); // Convertir a DTO
    }
}
