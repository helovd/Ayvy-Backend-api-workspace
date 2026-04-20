package com.ayvy.api_java.infrastructure.repository;

import com.ayvy.api_java.infrastructure.entitys.Categoria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome_categoria(String nome_categoria);

}