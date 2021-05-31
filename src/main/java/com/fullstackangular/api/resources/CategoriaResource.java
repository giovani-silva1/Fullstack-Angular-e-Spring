package com.fullstackangular.api.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fullstackangular.api.entities.Categoria;
import com.fullstackangular.api.service.CategoriaService;
import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> categorias() {
		return ResponseEntity.ok().body(categoriaService.listarCategorias());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Categoria> inserirCategoria(@RequestBody Categoria categoria) {
		Categoria categoriaInserida = categoriaService.criar(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(categoriaInserida.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(categoriaInserida);
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> encontrarCategoriaPorCodigo(@PathVariable Long codigo) {
		Optional<Categoria> categoriaEncontrada = categoriaService.encontrarCategoriaPorCodigo(codigo);
		return categoriaEncontrada.isPresent() ? ResponseEntity.ok().body(categoriaEncontrada)
				: ResponseEntity.notFound().build();
	}
}
