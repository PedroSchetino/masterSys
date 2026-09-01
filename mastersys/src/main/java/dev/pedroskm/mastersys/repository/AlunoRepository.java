package dev.pedroskm.mastersys.repository;

import dev.pedroskm.mastersys.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByEmail(String email);
}
