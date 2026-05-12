package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Pedido;
import com.ayvy.api_java.infrastructure.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service

public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {this.repository = repository;}

    //CREATE
    public String salvarPedido(Pedido pedido){
        repository.saveAndFlush(pedido);
        return ("Pedido Confirmado!");
    }

    //READ
    public Pedido buscarPedidoPorId(Integer id){

        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Pedido não encontrado")
        );
    }

    //DELETE
    public String deletarPedidoPorId(Integer id){
        repository.deleteById(id);
        return ("pedido cancelado!");
    }

    //UPDATE
    // !!! Não será possível atualizar o Pedido uma vez feito
    // !!! Pórem PedidoAtualizado está aqui caso seja necessário no futuro
    /*
    public void atualizarPedidoPorId(Integer id, Pedido pedido){
        Pedido pedidoEntity = buscarPedidoPorId(id);

        Pedido pedidoAtualizado = Pedido.builder()
                .status(pedidoEntity.getStatus())
                .valor(pedidoEntity.getValor())
                .dataPedido(pedidoEntity.getDataPedido())
                .id(pedidoEntity.getId())
                .build();

        repository.saveAndFlush(pedidoAtualizado);
    }*/


}
