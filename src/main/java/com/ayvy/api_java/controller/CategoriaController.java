package com.ayvy.api_java.controller;

import com.ayvy.api_java.business.CategoriaService;
import com.ayvy.api_java.infrastructure.entitys.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")

public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {this.categoriaService = categoriaService;}

    @PostMapping
    public ResponseEntity<Void> salvarCategoria(@RequestBody Categoria categoria) {
        categoriaService.salvarCategoria(categoria);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Categoria> buscarCateoriaPorNome_catgoria(@RequestParam String nome_categoria) {
        return ResponseEntity.ok(categoriaService.buscarCategoriaPorNome_categoria(nome_categoria));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarCategoriaPorId(@RequestParam Integer id,
                                                      @RequestParam Categoria categoria) {
        categoriaService.deletarCategoriaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCategoriaPorId(@RequestBody Integer id,
                                                        @RequestBody Categoria categoria){
        categoriaService.atualizarCategoriaPorId(id, categoria);
        return ResponseEntity.ok().build();
    }

}
