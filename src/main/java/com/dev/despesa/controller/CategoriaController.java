package com.dev.despesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.despesa.model.Categoria;
import com.dev.despesa.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listarCategorias();
	}

	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {
		if (categoria == null) {
			return null;
		}

		return categoriaService.inserirCategoria(categoria);
	}

	@GetMapping("/{id}")
	public Categoria buscar(@RequestParam("id") Long id) {
		return categoriaService.buscarCategoria(id);
	}

}
