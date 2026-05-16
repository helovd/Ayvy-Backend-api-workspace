package com.ayvy.api_java.business;

import com.ayvy.api_java.infrastructure.entitys.Cliente;
import com.ayvy.api_java.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteService {

    //Injetando o Repository manualmente aqui no service
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    //CRIANDO O CRUD:
    //Create
    //Read
    //Update
    //Delete


    //'void' é que não retorna nada:
    //Aqui é a parte de 'CREATE'
    public void salvarCliente(Cliente cliente){
        repository.saveAndFlush(cliente);
        //'saveAndFlush' = salva e fecha conexão com BD
    }

    //buscar cliente por email 'READ'
    public Cliente buscarClientePorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                //Uma exceção personalizada:
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    //deletar cliente por email 'DELETE' --> função criada no repository
    public void deletarClientePorId (Integer id){
        repository.deleteById(id);
    }

    //Atualizar os dados do cliente 'Update':
    public String atualizarClientePorId(Integer id, Cliente cliente){
        Cliente clienteEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário/cliente não encontrado")
        );

        if(cliente.getNome()!=null) {
            clienteEntity.setNome(cliente.getNome());
        }
        if(cliente.getEmail()!=null) {
            clienteEntity.setEmail(cliente.getEmail());
        }
        if(cliente.getCpf()!=null) {
            clienteEntity.setCpf(cliente.getCpf());
        }
        if(cliente.getTelefone()!=null) {
            clienteEntity.setTelefone(cliente.getTelefone());
        }
        if(cliente.getNomeUsuario()!=null) {
            clienteEntity.setNomeUsuario(cliente.getNomeUsuario());
        }
        if (cliente.getSenha()!=null) {
            clienteEntity.setSenha(cliente.getSenha());
        }

        repository.saveAndFlush(clienteEntity);
        return ("Alterações salvas com sucesso!");
    }

        /* ========= ! FORMA ANTIGA ! =============================================
        Cliente clienteAtualizado = Cliente.builder()
                .email(cliente.getEmail() != null ?
                        cliente.getEmail() : clienteEntity.getEmail())

                .nome(cliente.getNome() != null ?
                        cliente.getNome() : clienteEntity.getNome())

                .dataNascimento(cliente.getDataNascimento() != null ?
                        cliente.getDataNascimento() : clienteEntity.getDataNascimento())

                .telefone(cliente.getTelefone() != null ?
                        cliente.getTelefone() : clienteEntity.getTelefone())

                .senha(cliente.getSenha() != null ?
                        cliente.getSenha() : clienteEntity.getSenha())

                //CPF e Id não serão alterados:
                .cpf(clienteEntity.getCpf())
                .id(clienteEntity.getId())
                .build();

        repository.saveAndFlush(clienteAtualizado);
    }*/

}
