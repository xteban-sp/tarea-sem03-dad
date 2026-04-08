package upeu.edu.pe.ms_matricula.controller;

import upeu.edu.pe.ms_matricula.dto.MatriculaDTO;
import upeu.edu.pe.ms_matricula.service.MatriculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@Tag(name = "Matriculas", description = "Operaciones relacionadas con matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    @Operation(summary = "Listar matriculas", description = "Obtiene la lista completa de matriculas")
    public ResponseEntity<List<MatriculaDTO>> listar() {
        return ResponseEntity.ok(matriculaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar matricula por ID")
    public ResponseEntity<MatriculaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Registrar matricula")
    public ResponseEntity<MatriculaDTO> guardar(@Valid @RequestBody MatriculaDTO dto) {
        return new ResponseEntity<>(matriculaService.guardar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar matricula")
    public ResponseEntity<MatriculaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody MatriculaDTO dto) {
        return ResponseEntity.ok(matriculaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar matricula")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}