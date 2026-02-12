package simoes.roger.CadastroDeFuncionarios.service;

import org.springframework.stereotype.Service;
import simoes.roger.CadastroDeFuncionarios.dto.request.DepartmentRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.DepartmentResponseDTO;
import simoes.roger.CadastroDeFuncionarios.mapper.DepartmentMapper;
import simoes.roger.CadastroDeFuncionarios.model.DepartmentModel;
import simoes.roger.CadastroDeFuncionarios.repository.DepartmentRepository;

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
}
