package com.dev.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.despesa.model.FormaDePagamento;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long>{

}
