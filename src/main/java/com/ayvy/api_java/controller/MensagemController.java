package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.MensagemService;
import com.ayvy.api_java.infrastructure.entitys.Mensagem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensagem")

public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {this.mensagemService = mensagemService;}

    @PostMapping
    public ResponseEntity<Void> salvarMensagem(@RequestBody Mensagem mensagem){
        mensagemService.salvarMensagem(mensagem);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Mensagem> buscarMensagemPorTextoOuNome(@RequestParam String texto, String nome){
        return ResponseEntity.ok(mensagemService.buscarMensagemPorTextoOuNome(texto, nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarMensagemPorId(@RequestParam Integer id){
        mensagemService.deletarMensagemPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarMensagemPorId(@RequestParam Integer id,
                                                       @RequestBody Mensagem mensagem){
        mensagemService.atualizarMensagemPorId(id, mensagem);
        return ResponseEntity.ok().build();
    }

}
