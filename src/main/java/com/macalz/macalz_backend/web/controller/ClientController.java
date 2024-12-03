package com.macalz.macalz_backend.web.controller;

import com.macalz.macalz_backend.domain.dto.ClientDTO;
import com.macalz.macalz_backend.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }
}
