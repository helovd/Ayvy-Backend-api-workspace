package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.PedidoService;
import com.ayvy.api_java.infrastructure.entitys.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")

public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {this.pedidoService = pedidoService;}

    @PostMapping
    public ResponseEntity<Void> salvarPedido(@RequestBody Pedido pedido) {
        pedidoService.salvarPedido(pedido);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Pedido> buscarPedidoPorId(@RequestParam int id){
        return ResponseEntity.ok(pedidoService.buscarPedidoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPedidoPorId(@RequestParam int id){
        pedidoService.deletarPedidoPorId(id);
        return ResponseEntity.ok().build();
    }

    /* !!! EXPLICAÇÃO NA SERVICE =================================
    @PutMapping
    public ResponseEntity<Void> atualizarPedidoPorId(@RequestParam int id,
                                                    @RequestBody Pedido pedido) {
        pedidoService.atualizarPedidoPorId(id, pedido);
        return ResponseEntity.ok().build();
    }*/

}
