package com.ayvy.api_java.infrastructure.entitys;


import jakarta.persistence.*;
import lombok.*;

//Pegar e settar informações de algum atributo com Lombok:
@Getter
@Setter
//Para acessar a classe:
@AllArgsConstructor
@NoArgsConstructor
//Para futuros Updates:
@Builder
//Indicar que é tabela:
@Table(name = "produto")
@Entity

public class Produto {

    //Cria um valor automáticamente:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome_produto")
    private String nome_produto;

    @Column(name = "preco")
    private Integer preco;

    //Faltam:
    //Descrição String
    //data_criação LocalDateTime
    //preço deve ser BIGDECIMAL!!
}
