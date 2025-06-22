package com.estudo.desafio_crud_clientes.service;

import com.estudo.desafio_crud_clientes.dto.request.ClientRequestDTO;
import com.estudo.desafio_crud_clientes.dto.response.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    ClientResponseDTO findByIdClient(Long id);
    Page<ClientResponseDTO> findAllClients(Pageable pageable);
    ClientResponseDTO insertClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);
    void deleteClient(Long id);
}
