package ddaaniel.io.queueManagement.service;

import ddaaniel.io.queueManagement.domain.model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class FilaDePacientes {
    private PriorityQueue<Paciente> fila;

    // Inicializa a fila com um comparador que ordena por categoria de triagem e tempo de chegada
    public FilaDePacientes() {
        fila = new PriorityQueue<>(new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                // Primeiro, comparar a prioridade da triagem
                int prioridadeComparacao = Integer.compare(p1.getCategoriaTriagem().getPrioridade(), p2.getCategoriaTriagem().getPrioridade());

                // Se a prioridade for a mesma, comparar o tempo de chegada
                if (prioridadeComparacao == 0) {
                    return p1.getDataHoraChegada().compareTo(p2.getDataHoraChegada());
                }

                return prioridadeComparacao;
            }
        });
    }

    // Adicionar paciente na fila
    public void adicionarPaciente(Paciente paciente) {
        fila.add(paciente);
    }

    // Chamar próximo paciente
    public Paciente chamarProximo() {
        return fila.poll(); // Remove e retorna o paciente com maior prioridade
    }

    // Visualizar a fila
    public List<Paciente> verFila() {
        return new ArrayList<>(fila); // Retorna a lista em ordem de prioridade
    }
}