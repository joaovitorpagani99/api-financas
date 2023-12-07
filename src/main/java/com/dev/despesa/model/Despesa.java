package com.dev.despesa.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private StatusDespesa status;
	
	private BigDecimal valor;
	
	@CreationTimestamp
	private OffsetDateTime dataCriacao;
	
	private Date dataVencimento;
}
