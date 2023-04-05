package com.gerenciamento.curso.notification;

import com.gerenciamento.curso.model.Aluno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificadorSMS implements Notificador{

    public void notificar(Aluno aluno, String mensagem) {
        log.info("Sua matrícula está ativa!");
    }
}
