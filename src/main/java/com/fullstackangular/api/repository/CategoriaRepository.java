package com.fullstackangular.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstackangular.api.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
