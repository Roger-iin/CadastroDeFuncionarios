package simoes.roger.CadastroDeFuncionarios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simoes.roger.CadastroDeFuncionarios.dto.request.DepartmentRequestDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private int age;
    private String email;
    private DepartmentResponseDTO department;

}
