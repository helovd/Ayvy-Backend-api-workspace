package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Endereco;
import com.ayvy.api_java.infrastructure.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service

public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {this.repository = repository;}

    //Criar CRUD

    //create
    public void salvarEndereco(Endereco endereco) {
        this.repository.saveAndFlush(endereco);
    }

    //read
    public Endereco buscarEnderecoPorId(Long id) {

        return this.repository.findById(id).orElseThrow(
                () -> new RuntimeException("Endereço não encontrado")
        );
    }
    //delete
    public void deletarEnderecoPorId(Long id){
        repository.deleteById(id);
    }

    //update
    public Endereco atualizarEnderecoPorId(Long id, Endereco endereco) {
        Endereco enderecoEntity = repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Endereço não encontrado")
                );

        if (endereco.getCep() != null) {
            enderecoEntity.setCep(endereco.getCep());
        }

        if (endereco.getNumero() != null) {
            enderecoEntity.setNumero(endereco.getNumero());
        }

        return repository.saveAndFlush(enderecoEntity);
    }

}
