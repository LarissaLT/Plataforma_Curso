package com.gerenciamento.curso.service;

import com.gerenciamento.curso.model.Professor;
import com.gerenciamento.curso.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor cadastrar(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> listar() {
          return professorRepository.findAll();
    }

    public Professor buscar(Long professorId){
        return professorRepository.findById(professorId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                                "que é um tipo inválido. Corrija e informe um valor compatível."));
    }

    public Professor atualizar(Professor professor, Long professorId) {
        Professor professorAtual = professorRepository.findById(professorId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                                "que é um tipo inválido. Corrija e informe um valor compatível."));

        BeanUtils.copyProperties(professor, professorAtual, "id");

        return professorRepository.save(professorAtual);
    }

    public void excluir(Long professorId){
        if(!professorRepository.existsById(professorId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                    "que é um tipo inválido. Corrija e informe um valor compatível.");
        }
        professorRepository.deleteById(professorId);



    }
}
