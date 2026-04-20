package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Categoria;
import com.ayvy.api_java.infrastructure.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {this.repository = repository;}

//CREATE
    public void salvarCategoria(Categoria categoria){
        repository.saveAndFlush(categoria);
    }

//READ
    public Categoria buscarCategoriaNome_categoria(String nome_categoria){

        return repository.findByNome_categoria(nome_categoria).orElseThrow(
                //Uma exceção personalizada:
                () -> new RuntimeException("Categoria não encontrada")
        );
    }

//DELETE
    public void deletarCategoriaPorId(Integer id) {
        repository.deleteById(id);
    }


//UPDATE
   // public void atualizarCategoriaPorId(Integer id, Categoria categoria){
      //  Categoria categoriaRepository = repository.findById(id)
  //  }

}
