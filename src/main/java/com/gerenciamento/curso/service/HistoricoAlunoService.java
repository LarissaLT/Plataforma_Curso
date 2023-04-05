package com.gerenciamento.curso.service;

import com.gerenciamento.curso.model.*;
import com.gerenciamento.curso.repository.AlunoCursoRepository;
import com.gerenciamento.curso.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoAlunoService {

    private final AlunoCursoRepository alunoCursoRepository;
    private final AlunoRepository alunoRepository;

    public HistoricoAlunoService(AlunoCursoRepository alunoCursoRepository, AlunoRepository alunoRepository) {
        this.alunoCursoRepository = alunoCursoRepository;
        this.alunoRepository = alunoRepository;
    }

        public void cadastrar(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<AlunoCurso> cursosFiltrados = aluno.getCursos().stream().filter(e -> e.getCurso().getId() == cursoId).collect(Collectors.toList());
        if(cursosFiltrados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        AlunoCurso cursoCompletado = cursosFiltrados.get(0);
        aluno.getHistorico().add(cursoCompletado);
        aluno.getCursos().remove(cursoCompletado);

        alunoRepository.save(aluno);
    }


}
