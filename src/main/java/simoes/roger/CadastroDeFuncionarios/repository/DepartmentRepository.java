package simoes.roger.CadastroDeFuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simoes.roger.CadastroDeFuncionarios.model.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
}
