package com.estudo.desafio_crud_clientes.controller;

import com.estudo.desafio_crud_clientes.dto.response.ClientResponseDTO;
import com.estudo.desafio_crud_clientes.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> findByIdClient(@PathVariable Long id){
        ClientResponseDTO clientResponseDTO = clientService.findByIdClient(id);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> findAllClients(Pageable pageable){
        Page<ClientResponseDTO> clientResponseDTO = clientService.findAllClients(pageable);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

}
