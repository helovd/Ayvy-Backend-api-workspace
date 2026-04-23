package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.ProdutoService;
import com.ayvy.api_java.infrastructure.entitys.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//A uri:
//Vai fazer requisições pela 'localhost:8080/cliente'
@RequestMapping("/produto")

public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    //Para gravar dados:
    @PostMapping
    public ResponseEntity<Void> salvarCliente(@RequestBody Produto produto) {  //Necessário alterar para DTO
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

    //Para buscar:
    @GetMapping
    public ResponseEntity<Produto> buscarProdutoPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    //Para deletar:
    @DeleteMapping
    public ResponseEntity<Void> deletarProdutoPorId(@RequestParam Long id){
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.ok().build();
    }

    //Fazer alterações em TODOS os campos:
    @PutMapping
    public ResponseEntity<Void> atualizarProdutoPorId(@RequestParam Integer id,
                                                      @RequestBody Produto produto){
        produtoService.atualizarProdutoPorId(id, produto);
        return ResponseEntity.ok().build();
    }
}




