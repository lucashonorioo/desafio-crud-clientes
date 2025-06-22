package com.estudo.desafio_crud_clientes.service;

import com.estudo.desafio_crud_clientes.dto.request.ClientRequestDTO;
import com.estudo.desafio_crud_clientes.dto.response.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    ClientResponseDTO findByIdClient(Long id);
    List<ClientResponseDTO> findAllClients();
    ClientResponseDTO insertClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);
    void deleteClient(Long id);
}
