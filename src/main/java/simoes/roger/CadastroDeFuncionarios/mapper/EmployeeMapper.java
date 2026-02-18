package simoes.roger.CadastroDeFuncionarios.mapper;

import org.springframework.stereotype.Component;
import simoes.roger.CadastroDeFuncionarios.dto.request.EmployeeRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.EmployeeResponseDTO;
import simoes.roger.CadastroDeFuncionarios.model.DepartmentModel;
import simoes.roger.CadastroDeFuncionarios.model.EmployeeModel;

@Component
public class EmployeeMapper {

    private final DepartmentMapper departmentMapper;

    public EmployeeMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public EmployeeResponseDTO toResponseDTO(EmployeeModel employee){
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(departmentMapper.toResponseDTO(employee.getDepartment()));

        return dto;
    }

    public EmployeeModel toEntity(EmployeeRequestDTO dto, DepartmentModel department){

        EmployeeModel employee = new EmployeeModel();
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(department);

        return employee;
    }

    public void updateEntity(EmployeeModel employee, EmployeeRequestDTO dto, DepartmentModel department){
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(department);
    }

}
