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
@Table(name = "cliente")
@Entity

public class Cliente {

    //Cria um valor automáticamente:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Adicionando a ligação com a entidade endereço:
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;

    //!Utilizando String, por enquanto, já que LocalDate só permite com a inclusão de milissegundos
    @Column(name = "dataNascimento")
    private String dataNascimento;

    @Column(name = "cpf", unique = true)
    private String cpf;

    //permitir apenas números? a organização, como em telefone o padrão '11 9xxxx-xxxx', é com o front?
    @Column(name = "telefone", unique = true)
    private String telefone;

    //!Necessário avaliação de segurança!
    @Column(name = "senha")
    private String senha;

    @Column(name="nomeUsuario")
    private String nomeUsuario;


}
