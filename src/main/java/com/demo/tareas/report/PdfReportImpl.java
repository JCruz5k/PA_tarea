package com.demo.tareas.report;

import org.springframework.stereotype.Component;

@Component
public class PdfReportImpl implements ReportInterface {
    @Override
    public String tipo() {
        return "PDF";
    }

    @Override
    public <Report> byte[] generar(Report r) {
        System.out.println("Generando PDF");
        return new  byte[]{1,2,3};
    }
}
