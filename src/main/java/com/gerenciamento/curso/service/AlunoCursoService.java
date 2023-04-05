package com.gerenciamento.curso.service;

import com.gerenciamento.curso.model.*;
import com.gerenciamento.curso.repository.AlunoCursoRepository;
import com.gerenciamento.curso.repository.AlunoRepository;
import com.gerenciamento.curso.repository.CursoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoCursoService {

    private final AlunoCursoRepository alunoCursoRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;


    public AlunoCursoService(AlunoCursoRepository alunoCursoRepository, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoCursoRepository = alunoCursoRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    /*
    1) Cadastrar aluno em um curso (aluno, curso e alunoCurso)
    - Ator principal "alunoCurso" - coadij. "aluno" e "curso"
    - Alvo da ação: "alunoCurso"
    - Dependencias do alvo: "aluno" e "curso"

    2) Buscar um aluno

    3) Colocar aluno no alunoCurso

    4) Buscar curso

    5) Colocar curso a ser cadastrado no alunoCurso

    6) Salvar alunoCurso

     */

    public AlunoCurso cadastrar(AlunoCurso alunoCurso){
        AlunoCurso alunoNoCurso = new AlunoCurso();
        Aluno aluno = alunoRepository.findById(alunoCurso.getAluno().getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        Curso curso = cursoRepository.findById(alunoCurso.getCurso().getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        alunoNoCurso.setAluno(aluno);
        alunoNoCurso.setCurso(curso);
        alunoNoCurso.setNota(new Nota());

        return alunoCursoRepository.save(alunoNoCurso);
    }


    public AlunoCurso cadastrarAv1(Nota nota, Long alunoId, Long cursoId) {
        AlunoCursoId alunoCursoId = new AlunoCursoId();
        alunoCursoId.setAluno(alunoId);
        alunoCursoId.setCurso(cursoId);
        AlunoCurso alunoCurso = alunoCursoRepository.findById(alunoCursoId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        alunoCurso.getNota().setAv1(nota.getAv1());
        return alunoCursoRepository.save(alunoCurso);
    }

    public AlunoCurso cadastrarAv2(Nota nota, Long alunoId, Long cursoId) {
        AlunoCursoId alunoCursoId = new AlunoCursoId();
        alunoCursoId.setAluno(alunoId);
        alunoCursoId.setCurso(cursoId);
        AlunoCurso alunoCurso = alunoCursoRepository.findById(alunoCursoId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        alunoCurso.getNota().setAv2(nota.getAv2());
        return alunoCursoRepository.save(alunoCurso);
    }


    public List<AlunoCurso> listar() {
        return alunoCursoRepository.findAll();
    }

    public List<AlunoCurso> buscar(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<AlunoCurso> alunoCursos = aluno.getCursos();

        return alunoCursos;
    }

    public AlunoCurso buscarNota(Long alunoId, Long cursoId){
        AlunoCursoId alunoCursoId = new AlunoCursoId();
        alunoCursoId.setAluno(alunoId);
        alunoCursoId.setCurso(cursoId);
        AlunoCurso alunoCurso = alunoCursoRepository.findById(alunoCursoId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));


        double notaFinal = (alunoCurso.getNota().getAv1() + alunoCurso.getNota().getAv2()) / 2;
        alunoCurso.getNota().setNotaFinal(notaFinal);

        return alunoCursoRepository.save(alunoCurso);

    }


    }







