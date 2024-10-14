package ddaaniel.io.queueManagement.service;

import ddaaniel.io.queueManagement.domain.model.Paciente;
import ddaaniel.io.queueManagement.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilaDePacientes {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Adicionar paciente na fila (salva no banco de dados)
    public void adicionarPaciente(Paciente paciente) {
        String codigo;
        do {
            // Gera um código aleatório
            paciente.gerarCodigoCodigo();
            codigo = paciente.getCodigoCodigo();
        } while (!isCodigoUnico(codigo));  // Verifica se é único

        pacienteRepository.save(paciente);;
    }

    // Verifica se o código gerado é único no banco de dados
    private boolean isCodigoUnico(String codigo) {
        return !pacienteRepository.existsByCodigoCodigo(codigo);
    }

    // Chamar o próximo paciente (o de maior prioridade)
    public Paciente chamarProximo() {
        // Buscamos todos os pacientes e os ordenamos
        List<Paciente> fila = pacienteRepository.findAll().stream()
                .sorted((p1, p2) -> {
                    // Utilizando diretamente o método getPrioridade do enum CategoriaTriagem
                    int prioridadeComparacao = Integer.compare(
                            p1.getCategoriaTriagem().getPrioridade(),
                            p2.getCategoriaTriagem().getPrioridade()
                    );
                    if (prioridadeComparacao == 0) {
                        // Se as prioridades forem iguais, compara pelo horário de chegada
                        return p1.getDataHoraChegada().compareTo(p2.getDataHoraChegada());
                    }
                    return prioridadeComparacao;
                }).collect(Collectors.toList());
        //  O metodo ´sorted´ ordena a lista de paciente de acordo com a regra que colocamos
        //  dentro da função lambda, deixando a lista na ordem "da maior prioridade -> para a menor".

        if (!fila.isEmpty()) {
            Paciente proximo = fila.get(0);
            pacienteRepository.delete(proximo); // Remove o paciente do banco ao ser chamado
            return proximo;
        }
        return null; // Se não houver pacientes na fila
    }

    // Visualizar a fila (ordenada por prioridade e tempo de chegada)
    public List<Paciente> verFila() {
        return pacienteRepository.findAll().stream()
                .sorted((p1, p2) -> {
                    // Utilizando diretamente o método getPrioridade do enum CategoriaTriagem
                    int prioridadeComparacao = Integer.compare(
                            p1.getCategoriaTriagem().getPrioridade(),
                            p2.getCategoriaTriagem().getPrioridade()
                    );
                    if (prioridadeComparacao == 0) {
                        // Se as prioridades forem iguais, compara pelo horário de chegada
                        return p1.getDataHoraChegada().compareTo(p2.getDataHoraChegada());
                    }
                    return prioridadeComparacao;
                }).collect(Collectors.toList());
    }

    // Função auxiliar para obter a prioridade da categoria de triagem
    private int getPrioridadeCategoria(String categoriaTriagem) {
        switch (categoriaTriagem.toLowerCase()) {
            case "vermelho": return 1;
            case "amarelo": return 2;
            case "verde": return 3;
            case "azul": return 4;
            default: return 5; // Menor prioridade
        }
    }
}