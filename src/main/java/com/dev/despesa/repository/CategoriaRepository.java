package com.dev.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.despesa.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
