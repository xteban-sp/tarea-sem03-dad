package upeu.edu.pe.ms_curso.repository;

import upeu.edu.pe.ms_curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}