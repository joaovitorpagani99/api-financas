package com.dev.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.despesa.model.EconomiaFinalDoMes;

public interface EconomiaMesRepository extends JpaRepository<EconomiaFinalDoMes, Long>{

}
