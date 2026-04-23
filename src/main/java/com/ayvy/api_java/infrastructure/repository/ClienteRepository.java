package com.ayvy.api_java.infrastructure.repository;

import com.ayvy.api_java.infrastructure.entitys.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

   Optional<Cliente> findByEmail(String email);

   //'Transactional' = se der qualquer erro essa função não é executada
   // já que é uma operação sensível
   @Transactional
   void deleteByEmail(String email);

}
