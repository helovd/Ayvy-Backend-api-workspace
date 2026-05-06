package com.ayvy.api_java.controller;



import com.ayvy.api_java.business.PagamentoService;
import com.ayvy.api_java.infrastructure.entitys.Pagamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")

public class PagamentoController {

    private final PagamentoService pagamentoService;


    public PagamentoController(PagamentoService pagamentoService) {this.pagamentoService = pagamentoService;}

    @PostMapping
    public ResponseEntity<Void> salvarPagamento(@RequestBody Pagamento pagamento) {
        pagamentoService.salvarPagamento(pagamento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@RequestParam Integer id){
        return ResponseEntity.ok(pagamentoService.buscarPagamentoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPagamentoPorId(@RequestParam Integer id){
        pagamentoService.deletarPagamentoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarPagamentoPorId(@RequestParam Integer id,
                                                        @RequestBody Pagamento pagamento){
        pagamentoService.atualizarPagamentoPorId(id, pagamento);
        return ResponseEntity.ok().build();
    }

}
