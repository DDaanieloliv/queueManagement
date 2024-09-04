package ddaaniel.io.queueManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idTelefone;

    @Column(name = "n_telefone")
    public String numeroTelefone;
}
