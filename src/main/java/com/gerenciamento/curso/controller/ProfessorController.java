package com.gerenciamento.curso.controller;

import com.gerenciamento.curso.model.Professor;
import com.gerenciamento.curso.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    @ResponseBody
    public Professor cadastrar(@RequestBody Professor professor){
        return professorService.cadastrar(professor);
    }

    @GetMapping
    @ResponseBody
    public List<Professor> listar(){
        return professorService.listar();
    }

    @GetMapping("/{professorId}")
    @ResponseBody
    public Professor buscar(@PathVariable Long professorId){
        return professorService.buscar(professorId);
    }

    @PutMapping("/{professorId}")
    @ResponseBody
    public Professor atualizar(@RequestBody Professor professor, @PathVariable Long professorId){
        return professorService.atualizar(professor, professorId);
    }

    @DeleteMapping("/{professorId}")
    @ResponseBody
    public void excluir(@PathVariable Long professorId){
        professorService.excluir(professorId);
    }

}
