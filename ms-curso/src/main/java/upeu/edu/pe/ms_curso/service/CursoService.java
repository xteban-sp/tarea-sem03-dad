package upeu.edu.pe.ms_curso.service;

import upeu.edu.pe.ms_curso.dto.CursoDTO;
import upeu.edu.pe.ms_curso.entity.Curso;
import upeu.edu.pe.ms_curso.exception.RecursoNoEncontradoException;
import upeu.edu.pe.ms_curso.mapper.CursoMapper;
import upeu.edu.pe.ms_curso.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursoDTO> listar() {
        return cursoRepository.findAll()
                .stream()
                .map(CursoMapper::toDTO)
                .toList();
    }

    public CursoDTO buscarPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Curso no encontrado con id: " + id));
        return CursoMapper.toDTO(curso);
    }

    public CursoDTO guardar(CursoDTO dto) {
        Curso curso = CursoMapper.toEntity(dto);
        Curso guardado = cursoRepository.save(curso);
        return CursoMapper.toDTO(guardado);
    }

    public CursoDTO actualizar(Long id, CursoDTO dto) {
        Curso existente = cursoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Curso no encontrado con id: " + id));

        existente.setNombre(dto.getNombre());
        existente.setCodigo(dto.getCodigo());
        existente.setCreditos(dto.getCreditos());

        Curso actualizado = cursoRepository.save(existente);
        return CursoMapper.toDTO(actualizado);
    }

    public void eliminar(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Curso no encontrado con id: " + id));
        cursoRepository.delete(curso);
    }
}