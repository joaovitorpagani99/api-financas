package com.dev.despesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dev.despesa.exception.BadRequestException;
import com.dev.despesa.exception.ResourceNotFoundException;
import com.dev.despesa.model.Categoria;
import com.dev.despesa.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional
	public List<Categoria> listarCategorias() {
		return repository.findAll();
	}

	@Transactional
	public Categoria buscarCategoria(Long id) {
		Categoria categoria = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id + "Esse id não foi encontrado"));

		return categoria;
	}
	
	@Transactional
	public Categoria inserirCategoria(Categoria categoria) {
		if (categoria == null) {
			throw new ResourceNotFoundException("Esse objeto é invalido");
		}

		try {
			Categoria categoriaAtual = repository.save(categoria);
			return categoriaAtual;
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestException("Erro ao salvar: " + e.getMessage());
		}

	}

	@Transactional
	public void deletarCategoria(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException  e) {
			throw new ResourceNotFoundException(id + "Esse id não foi encontrado");
		}
	}

}
