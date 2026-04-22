package com.demo.tareas.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.demo.tareas.exception.ApiKeyInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(TareaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> noEncontrada(
            TareaNoEncontradaException ex) {
        return ResponseEntity.status(404)
                .body(ErrorResponse.of(404, ex.getMessage()));
    }
    @ExceptionHandler(TipoEnvioNoSoportadoException.class)
    public ResponseEntity<ErrorResponse> noEncontrada(
            TipoEnvioNoSoportadoException ex) {
        return ResponseEntity.status(404)
                .body(ErrorResponse.of(404, ex.getMessage()));
    }

    @ExceptionHandler(TipoReporteNoSoportadoException.class)
    public ResponseEntity<ErrorResponse> noEncontrada(
            TipoReporteNoSoportadoException ex) {
        return ResponseEntity.status(404)
                .body(ErrorResponse.of(404, ex.getMessage()));
    }

    @ExceptionHandler(ApiKeyInvalidaException.class)
    public ResponseEntity<ErrorResponse> apiKeyInvalida(
            ApiKeyInvalidaException ex) {
        return ResponseEntity.status(401)
                .body(ErrorResponse.of(401, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generico(Exception ex) {
        log.error("Error no manejado", ex);
        return ResponseEntity.status(500)
                .body(ErrorResponse.of(500, "Error interno"));
    }

}
