package simoes.roger.CadastroDeFuncionarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simoes.roger.CadastroDeFuncionarios.dto.request.EmployeeRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.EmployeeResponseDTO;
import simoes.roger.CadastroDeFuncionarios.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeRequestDTO employeeDto){
        EmployeeResponseDTO employeeCreated = employeeService.create(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeCreated);
    }

}
