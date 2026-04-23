package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.ClienteService;
import com.ayvy.api_java.infrastructure.entitys.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//A uri:
//Vai fazer requisições pela 'localhost:8080/cliente'
@RequestMapping("/cliente")

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Para gravar dados:
    @PostMapping
    public ResponseEntity<Void> salvarCliente(@RequestBody Cliente cliente) {  //Necessário alterar para DTO
        clienteService.salvarCliente(cliente);
        return ResponseEntity.ok().build();
    }

    //Para buscar:
    @GetMapping
    public ResponseEntity<Cliente> buscarClientePorEmail(@RequestParam String email) {
        return ResponseEntity.ok(clienteService.buscarClientePorEmail(email));
    }

    //Para deletar:
    @DeleteMapping
    public ResponseEntity<Void> deletarClientePorEmail(@RequestParam String email){
        clienteService.deletarClientePorEmail(email);
        return ResponseEntity.ok().build();
    }

    //Fazer alterações em TODOS os campos:
    @PutMapping
    public ResponseEntity<Void> atualizarClientePorId(@RequestParam Integer id,
                                                      @RequestBody Cliente cliente){
        clienteService.atualizarClientePorId(id, cliente);
        return ResponseEntity.ok().build();
    }

}

