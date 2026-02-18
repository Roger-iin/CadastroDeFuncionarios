package simoes.roger.CadastroDeFuncionarios.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import simoes.roger.CadastroDeFuncionarios.dto.request.EmployeeRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.EmployeeResponseDTO;
import simoes.roger.CadastroDeFuncionarios.mapper.EmployeeMapper;
import simoes.roger.CadastroDeFuncionarios.model.DepartmentModel;
import simoes.roger.CadastroDeFuncionarios.model.EmployeeModel;
import simoes.roger.CadastroDeFuncionarios.repository.DepartmentRepository;
import simoes.roger.CadastroDeFuncionarios.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    public EmployeeResponseDTO create(EmployeeRequestDTO employeeDto){
        DepartmentModel department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        EmployeeModel employee = mapper.toEntity(employeeDto, department);
        employee = employeeRepository.save(employee);

        return mapper.toResponseDTO(employee);
    }

    public List<EmployeeResponseDTO> listAll(){
        return employeeRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public EmployeeResponseDTO listById(Long id){
        return employeeRepository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public void delete(Long id){
        EmployeeModel employee = employeeRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }

    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto){
        EmployeeModel employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        DepartmentModel department = departmentRepository.findById(dto.getDepartmentId())
                        .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        mapper.updateEntity(employee, dto, department);
        return mapper.toResponseDTO(employeeRepository.save(employee));
    }


}
