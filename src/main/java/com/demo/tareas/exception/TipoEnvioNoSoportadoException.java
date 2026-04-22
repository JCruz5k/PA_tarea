package com.demo.tareas.exception;

public class TipoEnvioNoSoportadoException extends RuntimeException {
    public TipoEnvioNoSoportadoException(String tipoEnvio) {
        super("Tipo de envio:" + tipoEnvio + " no soportado");
    }
}
