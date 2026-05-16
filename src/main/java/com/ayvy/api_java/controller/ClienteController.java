package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.ClienteService;
import com.ayvy.api_java.infrastructure.entitys.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//A uri:
//Vai fazer requisições pela 'localhost:8080/clientes'
@RequestMapping("/clientes")

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
    @GetMapping("/{email}")
    public ResponseEntity<Cliente> buscarClientePorEmail(@PathVariable String email) {
        return ResponseEntity.ok(clienteService.buscarClientePorEmail(email));
    }

    @GetMapping
    public ResponseEntity <List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    //Para deletar:
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClientePorId(@PathVariable Integer id){
        clienteService.deletarClientePorEmail(email);
        return ResponseEntity.ok().build();
    }

    //Fazer alterações em TODOS os campos:
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarClientePorId(@PathVariable Integer id,
                                                      @RequestBody Cliente cliente){
        clienteService.atualizarClientePorId(id, cliente);
        return ResponseEntity.ok().build();
    }

}

