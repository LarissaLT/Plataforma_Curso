package com.gerenciamento.curso.service.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
public class AlunoCadastradoListener {

    @EventListener
    public void listener(AlunoCadastradoEvent event){
        log.info("Seu cadastro foi realizado, " + event.getNome() + "   " + event.getId());
    }

}
