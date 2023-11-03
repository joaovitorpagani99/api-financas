package com.dev.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.despesa.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
