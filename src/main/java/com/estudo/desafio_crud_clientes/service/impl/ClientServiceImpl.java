package com.estudo.desafio_crud_clientes.service.impl;

import com.estudo.desafio_crud_clientes.dto.request.ClientRequestDTO;
import com.estudo.desafio_crud_clientes.dto.response.ClientResponseDTO;
import com.estudo.desafio_crud_clientes.exception.exceptions.ResourceNotFoundExcecption;
import com.estudo.desafio_crud_clientes.model.Client;
import com.estudo.desafio_crud_clientes.repository.ClientRepository;
import com.estudo.desafio_crud_clientes.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    @Transactional
    public ClientResponseDTO findByIdClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow( () -> new ResourceNotFoundExcecption("Recurso não encontrado"));

        return new ClientResponseDTO(client);
    }

    @Override
    @Transactional
    public Page<ClientResponseDTO> findAllClients(Pageable pageable) {
        Page<Client> clientList = clientRepository.findAll(pageable);
        return clientList.map( c -> new ClientResponseDTO(c));
    }

    @Override
    public ClientResponseDTO insertClient(ClientRequestDTO clientRequestDTO) {
        return null;
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }


}
