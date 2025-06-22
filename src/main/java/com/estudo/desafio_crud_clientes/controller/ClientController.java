package com.estudo.desafio_crud_clientes.controller;

import com.estudo.desafio_crud_clientes.dto.request.ClientRequestDTO;
import com.estudo.desafio_crud_clientes.dto.response.ClientResponseDTO;
import com.estudo.desafio_crud_clientes.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<ClientResponseDTO> insertClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO){
        ClientResponseDTO clientResponseDTO = clientService.insertClient(clientRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientResponseDTO.getId()).toUri();
        return ResponseEntity.created(location).body(clientResponseDTO);
    }

}
