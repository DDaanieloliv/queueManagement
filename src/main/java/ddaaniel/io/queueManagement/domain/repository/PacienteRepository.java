package ddaaniel.io.queueManagement.domain.repository;

import ddaaniel.io.queueManagement.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
