package com.fullstackangular.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackangular.api.entities.Categoria;
import com.fullstackangular.api.repository.CategoriaRepository;

import javassist.NotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> listarCategorias() {
		return repo.findAll();
	}

	public Categoria criar(Categoria categoria) {
		Categoria categoriaNova = new Categoria(null, categoria.getNome());
		return repo.save(categoriaNova);
	}
	
	public Categoria encontrarCategoriaPorCodigo(Long codigo) {
		Optional<Categoria>  categoriaEncontrada = repo.findById(codigo);
		return categoriaEncontrada.get();
	} 
}
