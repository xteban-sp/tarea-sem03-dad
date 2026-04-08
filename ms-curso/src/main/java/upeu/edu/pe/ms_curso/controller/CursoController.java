package upeu.edu.pe.ms_curso.controller;

import upeu.edu.pe.ms_curso.dto.CursoDTO;
import upeu.edu.pe.ms_curso.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CursoDTO> guardar(@Valid @RequestBody CursoDTO dto) {
        return new ResponseEntity<>(cursoService.guardar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CursoDTO dto) {
        return ResponseEntity.ok(cursoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}