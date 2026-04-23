package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Produto;
import com.ayvy.api_java.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service

public class ProdutoService {

    //Injetando o Repository manualmente aqui no service
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    //CRIANDO O CRUD:
    //Create
    //Read
    //Update
    //Delete

    //"CREATE"
    public void salvarProduto(Produto produto){
        repository.saveAndFlush(produto);
    }

    //"READ"
    public Produto buscarProdutoPorId(Integer id){

        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
    }

    //"DELETE"
    public void deletarProdutoPorId(Long id){
        repository.deleteById(id);
    }

    //"UPDATDE"
    public void atualizarProdutoPorId(Integer id, Produto produto){
        Produto produtoEntity =  buscarProdutoPorId(id);

        Produto produtoAtualizado = Produto.builder()
                .nome_produto(produto.getNome_produto() != null ?
                        produto.getNome_produto() : produtoEntity.getNome_produto())
                .preco(produto.getPreco() != null ?
                        produto.getPreco() : produtoEntity.getPreco())
                .id(produtoEntity.getId())
                .build();

                repository.saveAndFlush(produtoAtualizado);
    }



}
