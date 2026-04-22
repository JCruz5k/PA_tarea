package com.demo.tareas.exception;

import java.time.Instant;
//
public record ErrorResponse(
        int    status,
        String mensaje,
        Instant timestamp
) {
    public static ErrorResponse of(int status, String mensaje) {
        return new ErrorResponse (status, mensaje, Instant.now());
    }
}
