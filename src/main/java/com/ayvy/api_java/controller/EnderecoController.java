package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.EnderecoService;
import com.ayvy.api_java.infrastructure.entitys.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")

public class EnderecoController {

    private final  EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {this.enderecoService = enderecoService;}

    @PostMapping
    public ResponseEntity<Void> salvarEndereco(@RequestBody Endereco endereco) {
        enderecoService.salvarEndereco(endereco);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Endereco> buscarEnderecoPorId(@RequestParam Long id) {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEnderecoPorId(@RequestParam Long id) {
        enderecoService.deletarEnderecoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarEnderecoPorId(@RequestParam Long id,
                                                        @RequestBody Endereco endereco){
        enderecoService.atualizarEnderecoPorId(id, endereco);
        return ResponseEntity.ok().build();
    }

}
