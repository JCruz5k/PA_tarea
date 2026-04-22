package com.demo.tareas.report;

public interface ReportInterface {
    String tipo();
    <Report> byte[] generar(Report r);
}
