package ddaaniel.io.queueManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.*;

@Entity
public class Paciente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String IdPaciente;

    public String nomeCompleto;

    public Sexo sexo;



}
