package com.semillero.practicatotal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semillero.practicatotal.entidades.DepartamentosEntity;
import com.semillero.practicatotal.repositories.DepartamentosRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/departamentos")
public class DepartamentosController {

	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	private DepartamentosEntity departamentos;
	
	@GetMapping("/listadepartamentos")
	public List<DepartamentosEntity> obtenerListaDepartamentos(){
		return departamentosRepository.findAll();
	}
	
	@GetMapping(value="/consultardepartamentobyid/{departamentoId}")
	public DepartamentosEntity obtenerDepartamentoById(@PathVariable(value="departamentoId") Integer departamentoId){
		Optional<DepartamentosEntity> departamentosEntity = departamentosRepository.findById(departamentoId);
		return departamentosEntity.get();
	}
	
	@PostMapping(value="/ingresardepartamento", consumes = "application/json")
	public DepartamentosEntity crearDepartamento(@RequestBody DepartamentosEntity departamentosEntity) {
		departamentos = departamentosRepository.saveAndFlush(departamentosEntity);
		return departamentos;
	}
	
	@PutMapping(value="/editardepartamento/{departamentoId}", consumes = "application/json")
	public ResponseEntity<DepartamentosEntity> editarDepartamento(@PathVariable(value="departamentoId") Integer departamentoId, @RequestBody DepartamentosEntity departamentosBody) {
		Optional<DepartamentosEntity> departamentosEntity = departamentosRepository.findById(departamentoId);
		if(departamentosEntity.isPresent()) {
			if(departamentosBody.getStrCodigoDaneDepartamento() != null) {
				departamentosEntity.get().setStrCodigoDaneDepartamento(departamentosBody.getStrCodigoDaneDepartamento());
			} 
			if(departamentosBody.getStrNombreDepartamento() != null) {
				departamentosEntity.get().setStrNombreDepartamento(departamentosBody.getStrNombreDepartamento());
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(departamentosRepository.save(departamentosEntity.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/eliminardepartamento/{departamentoId}")
	public void eliminarDepartamento(@PathVariable(value="departamentoId") Integer departamentoId) {
		departamentosRepository.deleteById(departamentoId);
	}
}
