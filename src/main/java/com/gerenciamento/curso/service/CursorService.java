package com.gerenciamento.curso.service;

import com.gerenciamento.curso.model.Aluno;
import com.gerenciamento.curso.model.Curso;

import com.gerenciamento.curso.model.Professor;
import com.gerenciamento.curso.repository.CursoRepository;
import com.gerenciamento.curso.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursorService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    public Curso cadastrar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listar(){
        return cursoRepository.findAll();
    }

    public Curso buscar(Long cursoId){
        return cursoRepository.findById(cursoId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                                "que é um tipo inválido. Corrija e informe um valor compatível."));
    }


//como que eu atualizo um curso
//       busca no banco o curso com o id solicitado na requisicao para ser atualizado
//        Verifica se o professor mudou
//    se mudou
//            buscar no banco o professor com o id solicitado na requisicao
//            trocar professor antigo do curso pelo novo
// substituir dados do curso a ser atualizado pelos dados do curso enviados na requisicao
//        ignorando o id pois ele nao pode ser modificado, e ignorando o preofesso pois ja mudamos ele manualmente
// salva o curso com os novos dados no banco
    public Curso atualizar(Curso cursoDaRequisicao, Long cursoId) {
//       busca no banco o curso com o id solicitado na requisicao para ser atualizado
        Curso cursoDoBanco = cursoRepository.findById(cursoId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));

//        Verifica se o professor mudou
        if(cursoDaRequisicao.getProfessor().getId() != cursoDoBanco.getProfessor().getId() ) {
//            buscar no banco o professor com o id solicitado na requisicao
            Professor professorNovo = professorRepository.findById(cursoDaRequisicao.getProfessor().getId())
                    .orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                                    "que é um tipo inválido. Corrija e informe um valor compatível."));
//            trocar professor antigo do curso pelo novo
            cursoDoBanco.setProfessor(professorNovo);
        }
// substituir dados do curso a ser atualizado pelos dados do curso enviados na requisicao
//        ignorando o id pois ele nao pode ser modificado, e ignorando o preofesso pois ja mudamos ele manualmente
        BeanUtils.copyProperties(cursoDaRequisicao, cursoDoBanco, "id", "professor");
// salva o curso com os novos dados no banco
        return cursoRepository.save(cursoDoBanco);
    }

    public void excluir(Long cursoId){
        if(!cursoRepository.existsById(cursoId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A propriedade recebeu um valor " +
                    "que é um tipo inválido. Corrija e informe um valor compatível.");
        }
        cursoRepository.deleteById(cursoId);



    }
}
