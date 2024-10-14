/*package ddaaniel.io.queueManagement.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Triagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Teiagem;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_categoria_triagem", nullable = false)
    private CategoriaTriagem categoriaTriagem;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @OneToMany(mappedBy = "triagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SinalVital> sinaisVitais;

    @OneToMany(mappedBy = "triagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sintoma> sintomas;

}
*/