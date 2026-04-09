package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Endereco;
import com.ayvy.api_java.infrastructure.repository.EnderecoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service

public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {this.repository = repository;}

    //Criar CRUD

    public void salvarEndereco(Endereco endereco) {
        this.repository.saveAndFlush(endereco);
    }

    public Endereco findByCep(String cep) {

        return this.repository.findByCep(cep).orElseThrow(
                () -> new RuntimeException("Endereço não encontrado")
        );
    }

    public void deletarEnderecoPorId(Long id){
        repository.deleteById(id);
    }
    /*
    public void atualizarEnderecoPorId(Long id, Endereco endereco) {
        Endereco enderecoEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Endereço não encontrado")
        );

        Endereco = enderecoAtualizado = Endereco.builder()
                .cep(endereco.getCep() != null ?
                        endereco.getCep : enderecoEntity.getCep())
                .build();
    }
    */
}
