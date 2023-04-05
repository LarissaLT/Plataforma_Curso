package com.gerenciamento.curso.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gerenciamento.curso.model.Aluno;
import com.gerenciamento.curso.model.MostreQuemTemATag;
import com.gerenciamento.curso.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagCadastrar.class)
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        return alunoService.cadastrar(aluno);
    }


    @GetMapping
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagListar.class)
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @GetMapping("/{alunoId}")
    @ResponseBody
    @JsonView(MostreQuemTemATag.TagBuscar.class)
    public Aluno buscar(@PathVariable Long alunoId){
        return alunoService.buscar(alunoId);
    }

    @PutMapping("/{alunoId}")
    @ResponseBody
    @JsonView({MostreQuemTemATag.TagAtualizar.class})
    public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long alunoId){
        return alunoService.atualizar(aluno, alunoId);
    }

    @DeleteMapping("/{alunoId}")
    @ResponseBody
    public void excluir(@PathVariable Long alunoId){
        alunoService.excluir(alunoId);
    }

}
