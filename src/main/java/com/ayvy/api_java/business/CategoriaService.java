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
    public Categoria buscarCategoriaPorNomeCategoria(String nomeCategoria){

        return repository.findByNomeCategoria(nomeCategoria).orElseThrow(
                //Uma exceção personalizada:
                () -> new RuntimeException("Categoria não encontrada")
        );
    }

    //DELETE
    public void deletarCategoriaPorId(Integer id) {
        repository.deleteById(id);
    }


//UPDATE
     public Categoria atualizarCategoriaPorId(Integer id, Categoria categoria){
         Categoria categoriaEntity = repository.findById(id).orElseThrow(
                 () -> new RuntimeException("Categoria não encontrada")
         );

         if(categoria.getNomeCategoria() != null){
         categoriaEntity.setNomeCategoria(categoria.getNomeCategoria());}

         return repository.saveAndFlush(categoriaEntity);
     }
          /* ========= ! FORMA ANTIGA ! =============================================
         Categoria categoriaAtualizado = Categoria.builder()
                 .id(categoriaEntity.getId())
                 .nomeCategoria(categoria.getNomeCategoria() != null ?
                         categoria.getNomeCategoria() : categoriaEntity.getNomeCategoria())
                 .build();

         repository.saveAndFlush(categoriaAtualizado);
      }*/

}
