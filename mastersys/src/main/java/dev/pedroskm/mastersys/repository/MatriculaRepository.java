package dev.pedroskm.mastersys.repository;

import dev.pedroskm.mastersys.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
