package com.demo.tareas.report;

import java.time.LocalDate;

public class ReportModel {
    private String titulo;
    private String contenido;
    private LocalDate fecha;

    public ReportModel(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
