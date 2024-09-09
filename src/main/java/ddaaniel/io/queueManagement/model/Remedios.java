package ddaaniel.io.queueManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;
@Entity
@Data
public class Remedios {

  public Long id_Remedio;

  public String nome_Remedio;

}
