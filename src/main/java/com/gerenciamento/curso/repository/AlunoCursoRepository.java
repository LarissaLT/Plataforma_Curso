package com.gerenciamento.curso.repository;

import com.gerenciamento.curso.model.AlunoCurso;
import com.gerenciamento.curso.model.AlunoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, AlunoCursoId> {
}
