package simoes.roger.CadastroDeFuncionarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simoes.roger.CadastroDeFuncionarios.dto.request.EmployeeRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.EmployeeResponseDTO;
import simoes.roger.CadastroDeFuncionarios.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeRequestDTO employeeDto){
        EmployeeResponseDTO employeeCreated = employeeService.create(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeCreated);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> listAll(){
        return ResponseEntity.ok(employeeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> listById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.listById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
