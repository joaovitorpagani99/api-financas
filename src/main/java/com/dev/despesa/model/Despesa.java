package com.dev.despesa.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.dev.despesa.model.Enum.StatusDespesa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	private StatusDespesa status;
	
	@Positive
	private BigDecimal valor;
	
	@CreationTimestamp
	private OffsetDateTime dataCriacao;

	private Date dataVencimento;
}
