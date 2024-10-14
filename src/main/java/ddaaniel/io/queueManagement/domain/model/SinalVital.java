/*package ddaaniel.io.queueManagement.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sinal_vital")
public class SinalVital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_triagem", nullable = false)
    private Triagem triagem;

    @Column(nullable = false, length = 50)
    private String tipo;  // Ex.: "Pressão Arterial", "Frequência Cardíaca"

    @Column(nullable = false, length = 50)
    private String valor;  // Ex.: "120/80 mmHg", "75 bpm"
}
*/