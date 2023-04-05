package com.gerenciamento.curso.service;

import com.gerenciamento.curso.model.Aluno;
import com.gerenciamento.curso.model.AlunoCurso;
import com.gerenciamento.curso.model.Matricula;
import com.gerenciamento.curso.repository.AlunoRepository;
import com.gerenciamento.curso.service.event.AlunoCadastradoEvent;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;


    public Aluno cadastrar(Aluno aluno){
        Matricula matricula = new Matricula();
//        gambiarra trocar para service de gerenciamento de matricula
        long numeroMatricula = generateMatricula();
        matricula.setNumero(numeroMatricula);
        matricula.setStatus(true);
        aluno.setMatricula(matricula);

        alunoRepository.save(aluno);

        eventPublisher.publishEvent(new AlunoCadastradoEvent(aluno.getId(),aluno.getNome()));

        return aluno;
    }

    private static long generateMatricula() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.of("Europe/Berlin");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now);
        long numero = LocalDateTime.now().toEpochSecond(zoneOffSet);
        return numero;
    }


    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno buscar(Long alunoId){
        return alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                                "que é um tipo inválido. Corrija e informe um valor compatível."));
    }


    public Aluno atualizar(Aluno aluno, Long alunoId) {
        Aluno alunoAtual = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                                "que é um tipo inválido. Corrija e informe um valor compatível."));

        BeanUtils.copyProperties(aluno, alunoAtual, "id", "matricula");

        return alunoRepository.save(alunoAtual);
    }

    public void excluir(Long alunoId){
        if(!alunoRepository.existsById(alunoId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                    "que é um tipo inválido. Corrija e informe um valor compatível.");
        }
        alunoRepository.deleteById(alunoId);

    }

}
