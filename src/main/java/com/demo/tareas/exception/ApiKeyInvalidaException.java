package com.demo.tareas.exception;

public class ApiKeyInvalidaException extends RuntimeException {
    public ApiKeyInvalidaException(String mensaje) {
        super(mensaje);
    }
}
