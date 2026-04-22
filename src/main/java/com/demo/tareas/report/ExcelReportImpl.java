package com.demo.tareas.report;

import org.springframework.stereotype.Component;

@Component
public class ExcelReportImpl implements ReportInterface {
    @Override
    public String tipo() {
        return "EXCEL";
    }

    @Override
    public <Report> byte[] generar(Report r) {
        System.out.println("Generando Excel...");
        return new byte[]{3,4};
    }
}
