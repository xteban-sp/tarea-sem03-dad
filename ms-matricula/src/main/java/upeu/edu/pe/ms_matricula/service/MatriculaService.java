package upeu.edu.pe.ms_matricula.service;

import upeu.edu.pe.ms_matricula.dto.MatriculaDTO;
import upeu.edu.pe.ms_matricula.entity.Matricula;
import upeu.edu.pe.ms_matricula.exception.RecursoNoEncontradoException;
import upeu.edu.pe.ms_matricula.mapper.MatriculaMapper;
import upeu.edu.pe.ms_matricula.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public List<MatriculaDTO> listar() {
        return matriculaRepository.findAll()
                .stream()
                .map(MatriculaMapper::toDTO)
                .toList();
    }

    public MatriculaDTO buscarPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Matricula no encontrada con id: " + id));
        return MatriculaMapper.toDTO(matricula);
    }

    public MatriculaDTO guardar(MatriculaDTO dto) {
        Matricula matricula = MatriculaMapper.toEntity(dto);
        Matricula guardada = matriculaRepository.save(matricula);
        return MatriculaMapper.toDTO(guardada);
    }

    public MatriculaDTO actualizar(Long id, MatriculaDTO dto) {
        Matricula existente = matriculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Matricula no encontrada con id: " + id));

        existente.setAlumno(dto.getAlumno());
        existente.setCursoId(dto.getCursoId());
        existente.setFecha(dto.getFecha());

        Matricula actualizada = matriculaRepository.save(existente);
        return MatriculaMapper.toDTO(actualizada);
    }

    public void eliminar(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Matricula no encontrada con id: " + id));
        matriculaRepository.delete(matricula);
    }
}
