package ddaaniel.io.queueManagement.domain.repository;

import ddaaniel.io.queueManagement.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(String cpf); // Podemos buscar pacientes pelo CPF também
}
