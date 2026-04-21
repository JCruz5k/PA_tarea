package com.demo.tareas;

public class TipoEnvioNoSoportadoException extends RuntimeException {
    public TipoEnvioNoSoportadoException(String tipoEnvio) {
        super("Tipo de envio:" + tipoEnvio + " no soportado");
    }
}
