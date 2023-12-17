 package com.dev.despesa.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class ComprasParceladas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Positive
	@NotBlank
	private BigDecimal valorTotal;
	
	@Positive
	@NotBlank
	private int qtdParcela;
	
	@Positive
	@NotBlank
	private int parcelasPagas;
}
