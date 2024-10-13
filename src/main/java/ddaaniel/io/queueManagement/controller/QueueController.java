package ddaaniel.io.queueManagement.controller;

import ddaaniel.io.queueManagement.domain.model.Paciente;
import ddaaniel.io.queueManagement.service.FilaDePacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fila")
public class QueueController {

    @Autowired
    private FilaDePacientes filaDePacientes;

    // Endpoint para adicionar um paciente à fila
    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarPaciente(@RequestBody Paciente paciente) {
        filaDePacientes.adicionarPaciente(paciente);
        return ResponseEntity.ok("Paciente adicionado à fila com sucesso!");
    }

    // Endpoint para chamar o próximo paciente
    @GetMapping("/chamar")
    public ResponseEntity<Paciente> chamarProximoPaciente() {
        Paciente proximo = filaDePacientes.chamarProximo();
        if (proximo != null) {
            return ResponseEntity.ok(proximo);
        }
        return ResponseEntity.noContent().build();
    }

    // Endpoint para visualizar a fila
    @GetMapping("/ver")
    public ResponseEntity<List<Paciente>> verFila() {
        List<Paciente> fila = filaDePacientes.verFila();
        return ResponseEntity.ok(fila);
    }

    // Endpoint para ver a posição de um paciente específico pelo ID
    @GetMapping("/posicao/{id}")
    public ResponseEntity<Integer> verPosicaoPaciente(@PathVariable Long id) {
        List<Paciente> fila = filaDePacientes.verFila();
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).getId_paciente().equals(id)) {
                return ResponseEntity.ok(i + 1); // Retorna a posição do paciente na fila (1-based)
            }
        }
        return ResponseEntity.notFound().build();
    }
}