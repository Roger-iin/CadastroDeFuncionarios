package simoes.roger.CadastroDeFuncionarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simoes.roger.CadastroDeFuncionarios.dto.request.DepartmentRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.DepartmentResponseDTO;
import simoes.roger.CadastroDeFuncionarios.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<DepartmentResponseDTO> create(@RequestBody DepartmentRequestDTO departmentDto){
        DepartmentResponseDTO departmentCreated = service.create(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departmentCreated);
    }
}
