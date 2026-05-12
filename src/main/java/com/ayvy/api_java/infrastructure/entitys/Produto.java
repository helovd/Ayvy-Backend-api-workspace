package com.ayvy.api_java.infrastructure.entitys;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal preco;

    @Column(name="descricao")
    private String descricao;

    //Data de criação e atualização da data toda vez que a entity sofre um UPDATE
    @CreationTimestamp
    @Column(name="criado_Em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}
