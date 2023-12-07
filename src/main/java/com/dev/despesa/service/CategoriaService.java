package com.dev.despesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.despesa.model.Categoria;
import com.dev.despesa.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> listarCategorias() {
		return repository.findAll();
	}
	
	public Categoria buscarCategoria(Long id) {
		Categoria categoria = repository.findById(id).get();

		if (categoria == null) {
			return null;
		}
		return categoria;
	}

	public Categoria inserirCategoria(Categoria categoria) {
		if (categoria == null) {
			return null;
		}
		
		Categoria categoriaAtual = repository.save(categoria);

		return categoriaAtual;
	}

	public void deletarCategoria(Long id) {
		repository.deleteById(id);
	}

}
