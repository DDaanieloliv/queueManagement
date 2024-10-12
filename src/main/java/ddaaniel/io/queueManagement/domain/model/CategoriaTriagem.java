package ddaaniel.io.queueManagement.domain.model;


import jakarta.persistence.*;
import lombok.Data;


public enum CategoriaTriagem {
    VERMELHO(1), // Emergência
    AMARELO(2),  // Urgência
    VERDE(3),    // Pouca urgência
    AZUL(4);     // Não urgência

    private final int prioridade;

    CategoriaTriagem(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }
}

/*
@Data
@Entity
@Table(name = "categoria_triagem")
public class CategoriaTriagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String cor;

    @Column(nullable = false)
    private Integer prioridade;

    @Column(nullable = false)
    private Integer tempoMaximoEspera; // em minutos

    @Column(length = 255)
    private String descricao;
}
*/