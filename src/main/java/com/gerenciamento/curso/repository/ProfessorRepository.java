package com.gerenciamento.curso.repository;

import com.gerenciamento.curso.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
