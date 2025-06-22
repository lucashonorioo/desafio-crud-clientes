package com.estudo.desafio_crud_clientes.repository;

import com.estudo.desafio_crud_clientes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
