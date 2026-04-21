package com.demo.tareas;

import java.time.LocalDate;

public class Report {
    private String titulo;
    private String contenido;
    private LocalDate fecha;

    public Report(String titulo, String contenido) {
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
