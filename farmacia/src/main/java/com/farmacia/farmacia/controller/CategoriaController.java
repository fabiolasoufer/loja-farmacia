package com.farmacia.farmacia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farmacia.farmacia.models.CategoriaModel;
import com.farmacia.farmacia.repository.CategoriaRepository;


@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")

public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<CategoriaModel> getById (@PathVariable(value = "id")long id){
		return repository.findById(id).map( resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

}
