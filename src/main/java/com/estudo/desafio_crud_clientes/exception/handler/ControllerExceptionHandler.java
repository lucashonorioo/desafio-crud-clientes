package com.estudo.desafio_crud_clientes.exception.handler;

import com.estudo.desafio_crud_clientes.exception.error.CustomError;
import com.estudo.desafio_crud_clientes.exception.exceptions.ResourceNotFoundExcecption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExcecption.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundExcecption e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
