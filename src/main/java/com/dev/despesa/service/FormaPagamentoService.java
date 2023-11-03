package com.dev.despesa.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.despesa.model.FormaDePagamento;
import com.dev.despesa.repository.FormaDePagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaDePagamentoRepository pagamemtoRepository;

	public List<FormaDePagamento> listar() {
		return pagamemtoRepository.findAll();
	}

	public FormaDePagamento salvar(FormaDePagamento pagamento) {
		return pagamemtoRepository.save(pagamento);
	}

	public FormaDePagamento atualizar(FormaDePagamento pagamento, Long id) {
		FormaDePagamento pagamentoAtual = pagamemtoRepository.findById(id).get();
		BeanUtils.copyProperties(pagamento, pagamentoAtual, "id");
		return pagamemtoRepository.save(pagamentoAtual);
	}

	public FormaDePagamento buscar(Long id) {
		FormaDePagamento pagamento = pagamemtoRepository.findById(id).get();
		return pagamento;
	}

	public void deletar(Long id) {
		pagamemtoRepository.deleteById(id);
	}

}
