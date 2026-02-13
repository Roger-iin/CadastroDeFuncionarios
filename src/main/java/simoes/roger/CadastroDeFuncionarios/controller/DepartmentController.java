package simoes.roger.CadastroDeFuncionarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simoes.roger.CadastroDeFuncionarios.dto.request.DepartmentRequestDTO;
import simoes.roger.CadastroDeFuncionarios.dto.response.DepartmentResponseDTO;
import simoes.roger.CadastroDeFuncionarios.service.DepartmentService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
