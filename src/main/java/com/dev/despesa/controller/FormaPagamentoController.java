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

import com.dev.despesa.model.FormaDePagamento;
import com.dev.despesa.service.FormaPagamentoService;

@RestController
@RequestMapping("formaPagamento")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoService pagamentoService;
	
	@GetMapping
	public List<FormaDePagamento> listar(){
		return pagamentoService.listar();
	}
	
	@PostMapping
	public FormaDePagamento cadastrar(@RequestBody FormaDePagamento formaDePagamento) {
		
		return pagamentoService.salvar(formaDePagamento);
	}
	
	@GetMapping("/{id}")
	public FormaDePagamento buscar(@PathVariable Long id) {
		return pagamentoService.buscar(id);
	}

	@PutMapping("/{id}")
	public FormaDePagamento atualizar(@PathVariable Long id,
													@RequestBody FormaDePagamento formaDePagamento) {
		FormaDePagamento formaPagamento = pagamentoService.atualizar(formaDePagamento, id);
		return formaPagamento;
	}
	
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		pagamentoService.deletar(id);
	}
}
