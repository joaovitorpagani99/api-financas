package com.dev.despesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.despesa.model.Despesa;
import com.dev.despesa.model.StatusDespesa;
import com.dev.despesa.service.DespesaService;

@RestController
@RequestMapping("despesa")
public class DespesaController {

	@Autowired
	private DespesaService despesaService;

	@GetMapping()
	public List<Despesa> listar() {
		return despesaService.listarDespesas();
	}
	
	@GetMapping("/{id}")
	public Despesa buscar(@PathVariable("id") Long id) {
		return despesaService.buscar(id);
	}
	
	@PostMapping()
	public Despesa cadastrarDespesa(@RequestBody Despesa despesa) {
		despesa.setStatus(StatusDespesa.ABERTO);
		Despesa objeto = despesaService.salvar(despesa);
		return objeto;
	}
	
	@PutMapping("{id}")
	public Despesa atualizarDespesa(@RequestBody Despesa despesa, @PathVariable("id") Long id) {
		Despesa despesaAtual = despesaService.atualizar(despesa, id);
		return despesaAtual;
	}
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Long id) {
		 despesaService.apagar(id);
		 
	}
	
}
