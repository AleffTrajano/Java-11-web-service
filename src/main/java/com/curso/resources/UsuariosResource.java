package com.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.entities.Usuarios;
import com.curso.services.UsuariosService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosResource {

	@Autowired
	private UsuariosService service;

	@GetMapping
	public ResponseEntity<List<Usuarios>> findAll() {
		List<Usuarios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuarios> findById(@PathVariable Long id) {
		Usuarios obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<Usuarios> insert(@RequestBody Usuarios obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Usuarios> deletarUsuario(@PathVariable Long id){
		service.deletarUsuario(id);
		return new ResponseEntity<Usuarios>(HttpStatus.OK);
	}
	}
