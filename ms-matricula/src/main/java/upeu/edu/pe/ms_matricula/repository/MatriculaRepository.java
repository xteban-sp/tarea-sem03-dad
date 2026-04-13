package upeu.edu.pe.ms_matricula.repository;

import upeu.edu.pe.ms_matricula.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}