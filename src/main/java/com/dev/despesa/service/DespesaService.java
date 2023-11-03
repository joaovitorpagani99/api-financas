package com.dev.despesa.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.despesa.model.Despesa;
import com.dev.despesa.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	public List<Despesa> listarDespesas(){
		return despesaRepository.findAll();
	}
	
	public Despesa buscar(Long id) {
			Despesa despesa = despesaRepository.findById(id).orElseThrow(()->
																			new RuntimeException("Erro ao buscar"));
			return despesa;
		
	}

	public Despesa salvar(Despesa despesa){
		if (despesa == null) {
			throw  new IllegalArgumentException("Objeto null");
		}
		return despesaRepository.save(despesa);
	}
	
	public Despesa atualizar(Despesa despesa, Long id) {
		Despesa despesaAtual = despesaRepository.findById(id).get();
		BeanUtils.copyProperties(despesa, despesaAtual, "id","dataCriacao","dataVencimento");
		return this.salvar(despesaAtual);
	}
	
	public void apagar(Long id) {
		despesaRepository.deleteById(id);
	}
}
