package com.dev.despesa.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.dev.despesa.exception.BadRequestException;
import com.dev.despesa.exception.DataConflictException;
import com.dev.despesa.exception.ResourceNotFoundException;
import com.dev.despesa.model.FormaDePagamento;
import com.dev.despesa.repository.FormaDePagamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaDePagamentoRepository pagamemtoRepository;

	public List<FormaDePagamento> listar() {
		return pagamemtoRepository.findAll();
	}

	@Transactional
	public FormaDePagamento salvar(FormaDePagamento pagamento) {		
		FormaDePagamento dePagamento = pagamemtoRepository.findByDescricao(pagamento.getDescricao()).get();
		System.out.println("teste: "+dePagamento.toString());
		if(dePagamento != null) {
			throw new DataConflictException("Forma de pagamento ja existe.");
		}
		System.out.println("aqui"+ pagamento.toString());

		try {
			return pagamemtoRepository.save(pagamento);
		} catch (Exception e) {
			throw new BadRequestException("Erro ao salvar a forma de pagamento: "+ e.getMessage());
		}
	}

	@Transactional
	public FormaDePagamento buscar(Long id) {
		FormaDePagamento pagamento = pagamemtoRepository.findById(id)
				.orElseThrow(() -> new ResourceAccessException(id + " - Essa forma de pagamento não foi encontrada"));
		return pagamento;
	}

	@Transactional
	public FormaDePagamento atualizar(FormaDePagamento pagamento, Long id) {
		try {
			FormaDePagamento pagamentoAtual = buscar(id);
			BeanUtils.copyProperties(pagamento, pagamentoAtual, "id");
			return pagamemtoRepository.save(pagamentoAtual);
		} catch (ResourceNotFoundException e) {
			throw new BadRequestException("Erro ao atualizar a forma de pagamento: " + e.getMessage());
		}
	}

    @Transactional
	public void deletar(Long id) {
		try {
			pagamemtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id + " - Essa forma de pagamento não foi encontrada");
		} catch (Exception e) {
			throw new BadRequestException("Erro ao deletar a forma de pagamento: " + e.getMessage());
		}
	}
}
