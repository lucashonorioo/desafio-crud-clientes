package com.estudo.desafio_crud_clientes.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientRequestDTO {
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String name;

    private String cpf;
    private Double income;

    @PastOrPresent(message = "A data não pode ser futura")
    private LocalDate birthDate;
    private Integer children;

    public ClientRequestDTO(){

    }

    public ClientRequestDTO(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
