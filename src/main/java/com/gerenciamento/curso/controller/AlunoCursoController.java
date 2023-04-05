package com.gerenciamento.curso.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gerenciamento.curso.model.*;
import com.gerenciamento.curso.service.AlunoCursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno-curso")
public class AlunoCursoController {

    private final AlunoCursoService alunoCursoService;

    public AlunoCursoController(AlunoCursoService alunoCursoService) {
        this.alunoCursoService = alunoCursoService;
    }

    @PostMapping
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagCadastrarAlunoNoCurso.class)
    public AlunoCurso cadastrar(@RequestBody AlunoCurso alunoCurso){
        return alunoCursoService.cadastrar(alunoCurso);
    }

    @PostMapping("/av1/aluno/{alunoId}/curso/{cursoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagCadastrarAv1.class)
    public AlunoCurso cadastrarAv1(@RequestBody Nota nota, @PathVariable Long alunoId, @PathVariable Long cursoId){
        return alunoCursoService.cadastrarAv1(nota, alunoId, cursoId);
    }

    @PostMapping("/av2/aluno/{alunoId}/curso/{cursoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagCadastrarAv2.class)
    public AlunoCurso cadastrarAv2(@RequestBody Nota nota, @PathVariable Long alunoId, @PathVariable Long cursoId){
        return alunoCursoService.cadastrarAv2(nota, alunoId, cursoId);
    }

    @GetMapping
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagCadastrarAlunoNoCurso.class)
    public List<AlunoCurso> listar(){
        return alunoCursoService.listar();
    }

    @GetMapping("/aluno/{alunoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagBuscarAlunoCurso.class)
    public List<AlunoCurso> buscar(@PathVariable Long alunoId){
        return alunoCursoService.buscar(alunoId);
    }

    @GetMapping("/aluno/{alunoId}/curso/{cursoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagBuscarNotaFinal.class)
    public AlunoCurso buscarNota(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        return alunoCursoService.buscarNota(alunoId, cursoId);
    }

}
