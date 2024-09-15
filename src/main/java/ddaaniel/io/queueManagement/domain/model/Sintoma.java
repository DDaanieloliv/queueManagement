package ddaaniel.io.queueManagement.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sintoma")
public class Sintoma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_triagem", nullable = false)
    private Triagem triagem;

    @Column(nullable = false, length = 255)
    private String descricao;
}
