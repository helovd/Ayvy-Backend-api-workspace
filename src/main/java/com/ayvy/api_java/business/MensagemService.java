package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Mensagem;
import com.ayvy.api_java.infrastructure.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service

public class MensagemService {

    private final MensagemRepository repository;

    public MensagemService(MensagemRepository repository) {this.repository = repository;}

    //CREATE
    public void salvarMensagem(Mensagem mensagem){
        repository.saveAndFlush(mensagem);
    }

    //READ
    public Mensagem buscarMensagemPorTextoOuNome(String texto, String nome){
        return repository.findByTextoOrNome(texto, nome).orElseThrow(
                () -> new RuntimeException("Conversa não encontrada")
        );
    }

    //DELETE - por texto? por nome? seria a conversa toda?
    public void deletarMensagemPorId(Integer id){
        repository.deleteById(id);
    }

    //UPDATE - ou Editar mensagem no futuro
    public Mensagem atualizarMensagemPorId(Integer id, Mensagem mensagem){
        Mensagem mensagemEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Mensagem não encontrada")
        );

        if(mensagem.getTexto() != null){
        mensagemEntity.setTexto(mensagem.getTexto());}

        return repository.saveAndFlush(mensagemEntity);
    }

  /* ========= ! FORMA ANTIGA ! =============================================
        //Talvez possamos reomear para 'editada' depois
        Mensagem mensagemAtualizada = Mensagem.builder()
                .texto(mensagem.getTexto() != null ?
                        mensagem.getTexto() : mensagemEntity.getTexto())
                .nome(mensagemEntity.getNome())
                .dataEnvio(mensagemEntity.getDataEnvio())
                .dataRecebimento(mensagemEntity.getDataRecebimento())
                .id(mensagemEntity.getId())
                .build();
    }*/
}
