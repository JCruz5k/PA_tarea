package com.demo.tareas;

public class TareaNoEncontradaException extends RuntimeException {
    public TareaNoEncontradaException(Long id) {
            super("Tarea " + id + " no existe");
        }
}
