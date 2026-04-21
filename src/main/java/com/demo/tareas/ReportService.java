package com.demo.tareas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final Map<String, NotificationInterface> senders;
    private final Map<String, ReportInterface> generators;
    public ReportService(List<ReportInterface> generators,
                         List<NotificationInterface> senders) {

        this.generators = generators.stream()
                .collect(Collectors.toMap(ReportInterface::tipo, g -> g));

        this.senders = senders.stream()
                .collect(Collectors.toMap(NotificationInterface::tipo, s -> s));
    }

    public void generarYEnviar(Report r, String destino,
                               String tipoReporte,
                               String tipoEnvio) {
        ReportInterface generator = Optional
                .ofNullable(generators.get(tipoReporte))
                .orElseThrow(() ->
                        new TipoReporteNoSoportadoException(tipoReporte)
                );

        NotificationInterface sender = Optional
                .ofNullable(senders.get(tipoEnvio))
                .orElseThrow(() ->
                        new TipoEnvioNoSoportadoException(tipoEnvio)
                );


        byte[] data = generator.generar(r);
        sender.enviar(destino, data);
    }
}
