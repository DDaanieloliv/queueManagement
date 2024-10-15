package ddaaniel.io.queueManagement.controller;

import ddaaniel.io.queueManagement.domain.model.Paciente;
import ddaaniel.io.queueManagement.service.FilaDePacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketPacienteController {

    @Autowired
    private FilaDePacientes filaDePacientes;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Endpoint que chama o próximo paciente e envia o nome via WebSocket
    @GetMapping("/chamarPaciente")
    public Paciente chamarProximoPaciente() {
        Paciente proximo = filaDePacientes.chamarProximo();

        // Se houver um próximo paciente, notifica todos os clientes conectados via WebSocket
        if (proximo != null) {
            messagingTemplate.convertAndSend("/topic/pacienteAtual", proximo.getNomeCompleto());
        }
        return proximo;
    }

    /*
     No lado do clienteprecisará de um código JavaScript para se conectar ao WebSocket e exibir o nome do
     paciente que foi chamado.


    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Paciente Atual</title>
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.5.0/dist/sockjs.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
    </head>
    <body>
        <h2>Paciente Atual:</h2>
        <p id="pacienteAtual">Aguardando paciente...</p>

        <script>
            var socket = new SockJS('/fila-websocket');
            var stompClient = Stomp.over(socket);

            stompClient.connect({}, function (frame) {
                console.log('Conectado: ' + frame);

                // Subscribe para ouvir as mensagens enviadas pelo servidor
                stompClient.subscribe('/topic/pacienteAtual', function (message) {
                    document.getElementById("pacienteAtual").innerHTML = message.body;
                });
            });
        </script>
    </body>
    </html>
    */
}
