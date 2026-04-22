package com.demo.tareas.notification;

import org.springframework.stereotype.Component;
//
@Component
public class EmailSenderNotificationImpl implements NotificationInterface {
    @Override
    public String tipo() {
        return "EMAIL";
    }
    @Override
    public void enviar(String destino, byte[] contenido) {
        System.out.println("Enviando EMAIL a " + destino);
    }
}
