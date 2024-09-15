package ddaaniel.io.queueManagement.domain.repository;

import ddaaniel.io.queueManagement.domain.model.CategoriaTriagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaTriagemRepository extends JpaRepository<CategoriaTriagem, Long> {
}
