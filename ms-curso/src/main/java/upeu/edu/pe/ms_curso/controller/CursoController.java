package upeu.edu.pe.ms_curso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CursoController {

    @GetMapping("/api/cursos")
    public List<Map<String, Object>> listarCursos() {
        return List.of(
                Map.of("id", 1, "nombre", "Desarrollo de Aplicaciones Distribuidas"),
                Map.of("id", 2, "nombre", "Base de Datos"),
                Map.of("id", 3, "nombre", "Ingenieria de Software")
        );
    }
}