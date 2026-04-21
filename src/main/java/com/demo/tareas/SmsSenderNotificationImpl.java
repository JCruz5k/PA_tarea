package com.demo.tareas;

import org.springframework.stereotype.Component;

@Component
public class SmsSenderNotificationImpl implements NotificationInterface {
    @Override
    public String tipo() {
        return "SMS";
    }

    @Override
    public void enviar(String destino, byte[] contenido) {
        System.out.println("Enviando SMS a " + destino);
    }
}
