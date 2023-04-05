package com.gerenciamento.curso.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gerenciamento.curso.model.Curso;
import com.gerenciamento.curso.model.MostreQuemTemATag;
import com.gerenciamento.curso.service.CursorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursorService cursorService;

    @PostMapping
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagCadastrar.class)
    public Curso cadastrar(@RequestBody Curso curso){
        return cursorService.cadastrar(curso);
    }

    @GetMapping
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagListar.class)
    public List<Curso> listar(){
        return cursorService.listar();
    }

    @GetMapping("/{cursoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagBuscar.class)
    public Curso buscar(@PathVariable Long cursoId){
        return cursorService.buscar(cursoId);
    }

    @PutMapping("/{cursoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagAtualizar.class)
    public Curso atualizar(@RequestBody Curso curso, @PathVariable Long cursoId){
        return cursorService.atualizar(curso, cursoId);
    }

    @DeleteMapping("/{cursoId}")
    @ResponseBody
    public void excluir(@PathVariable Long cursoId){
        cursorService.excluir(cursoId);
    }

}
