package upeu.edu.pe.ms_matricula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MatriculaController {

    @GetMapping("/api/matriculas")
    public List<Map<String, Object>> listarMatriculas() {
        return List.of(
                Map.of("id", 1, "alumno", "Juan Perez", "curso", "DAD"),
                Map.of("id", 2, "alumno", "Maria Lopez", "curso", "Base de Datos"),
                Map.of("id", 3, "alumno", "Carlos Ramos", "curso", "Ingenieria de Software")
        );
    }
}