package com.gerenciamento.curso.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gerenciamento.curso.model.Aluno;
import com.gerenciamento.curso.model.Curso;
import com.gerenciamento.curso.model.MostreQuemTemATag;
import com.gerenciamento.curso.model.Nota;
import com.gerenciamento.curso.service.HistoricoAlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/historico")
public class HistoricoAlunoController {

    private final HistoricoAlunoService historicoAlunoService;

    public HistoricoAlunoController(HistoricoAlunoService historicoAlunoService) {
        this.historicoAlunoService = historicoAlunoService;
    }

    @PostMapping("/aluno/{alunoId}")
    @ResponseBody
    public void cadastrar(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        historicoAlunoService.cadastrar(alunoId, cursoId);
    }



}
