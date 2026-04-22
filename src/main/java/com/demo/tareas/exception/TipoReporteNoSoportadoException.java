package com.demo.tareas.exception;

public class TipoReporteNoSoportadoException extends RuntimeException {
    public TipoReporteNoSoportadoException(String tipoReporte) {
        super("Tipo de Reporte:" + tipoReporte + " no soportado");
    }
}
