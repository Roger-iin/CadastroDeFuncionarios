package simoes.roger.CadastroDeFuncionarios.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    private String name;
    private int age;
    private String email;
    private Long departmentId;

}
