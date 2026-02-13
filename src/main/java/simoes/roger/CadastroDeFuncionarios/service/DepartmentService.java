package simoes.roger.CadastroDeFuncionarios.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import simoes.roger.CadastroDeFuncionarios.dto.request.DepartmentRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.DepartmentResponseDTO;
import simoes.roger.CadastroDeFuncionarios.mapper.DepartmentMapper;
import simoes.roger.CadastroDeFuncionarios.model.DepartmentModel;
import simoes.roger.CadastroDeFuncionarios.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DepartmentResponseDTO create(DepartmentRequestDTO departmentDto){
        DepartmentModel department = mapper.toEntity(departmentDto);
        department = repository.save(department);
        return mapper.toResponseDTO(department);
    }

    public List<DepartmentResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public DepartmentResponseDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
    }

    public void delete(Long id){
        DepartmentModel department = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        repository.deleteById(id);
    }
}
