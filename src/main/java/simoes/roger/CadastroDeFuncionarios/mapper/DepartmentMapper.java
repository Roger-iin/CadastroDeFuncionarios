package simoes.roger.CadastroDeFuncionarios.mapper;

import org.springframework.stereotype.Component;
import simoes.roger.CadastroDeFuncionarios.dto.request.DepartmentRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.DepartmentResponseDTO;
import simoes.roger.CadastroDeFuncionarios.model.DepartmentModel;

@Component
public class DepartmentMapper {

    public DepartmentResponseDTO toResponseDTO(DepartmentModel department){
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(dto.getId());
        dto.setDepartmentName(department.getDepartmentName());

        return dto;
    }

    public DepartmentModel toEntity(DepartmentRequestDTO dto){
        DepartmentModel department = new DepartmentModel();
        department.setDepartmentName(dto.getDepartmentName());

        return department;
    }

}
