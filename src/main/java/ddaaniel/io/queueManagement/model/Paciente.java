package ddaaniel.io.queueManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;

@Data
@Entity //Define que a classe será mapeada no BD como uma entidade.
public class Paciente{

    @Id //Define que o atributo anotado como chave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Estrategia de geração de chave.
    public Long IdPaciente;

    @Column(name = "nome_completo")
    public String nomeCompleto;

    public LocalDate dataNascimento;

    public Sexo sexo;

    @Column(unique = true , nullable = false)
    public String registroGeral;

    @Column(unique = true , nullable = false)
    public String cpf;

    public List<Telefone> telefone;

    public List<Remedios> remedios;

    public List<Alergias> alergias;





}
