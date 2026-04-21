package com.demo.tareas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/reporte")
    public ResponseEntity<Map<String, String>> generarReporte(
        @RequestParam String tipoReporte,
        @RequestParam String tipoEnvio,
        @RequestParam String destino) {

            Report r = new Report("Demo", "Contenido");

            service.generarYEnviar(r, destino, tipoReporte, tipoEnvio);

            return ResponseEntity
                    .status(200)
                    .body(Map.of("status","200","mensaje","OK"));
    }
}
