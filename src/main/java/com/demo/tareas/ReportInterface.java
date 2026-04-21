package com.demo.tareas;

public interface ReportInterface {
    String tipo();
    <Report> byte[] generar(Report r);
}
