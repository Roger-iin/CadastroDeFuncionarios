package simoes.roger.CadastroDeFuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simoes.roger.CadastroDeFuncionarios.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
