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

import com.semillero.practicatotal.entidades.CiudadesEntity;
import com.semillero.practicatotal.repositories.CiudadesRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/ciudades")
public class CiudadesController {

	@Autowired
	private CiudadesRepository ciudadesRepository;
	
	private CiudadesEntity ciudadesEntity;
	
	@GetMapping("/listaciudades")
	public List<CiudadesEntity> obtenerListaCiudades(){
		return ciudadesRepository.findAll();
	}
	
	@GetMapping("/consultarciudadbyid/{ciudadId}")
	public CiudadesEntity obtenerCiudadById(@PathVariable(value="ciudadId") Integer ciudadId) {
		Optional<CiudadesEntity> optionalCiudades= ciudadesRepository.findById(ciudadId);
		return optionalCiudades.get();
	}
	
	@PostMapping(value="/ingresarciudades", consumes = "application/json")
	public CiudadesEntity ingresarCiudades(@RequestBody CiudadesEntity ciudadesBody) {
		ciudadesEntity = ciudadesRepository.saveAndFlush(ciudadesBody);
		return ciudadesEntity;
	}
	
	@PutMapping(value="/editarciudad/{ciudadId}", consumes = "application/json")
	public ResponseEntity<CiudadesEntity> editarCiudad(@PathVariable(value="ciudadId") Integer ciudadId, @RequestBody CiudadesEntity ciudadesBody) {
		Optional<CiudadesEntity> optionalCiudades = ciudadesRepository.findById(ciudadId);
		if(optionalCiudades.isPresent()) {
			optionalCiudades.get().setStrCodigoDaneCiudad(ciudadesBody.getStrCodigoDaneCiudad());
			optionalCiudades.get().setStrNombreCiudad(ciudadesBody.getStrNombreCiudad());
			optionalCiudades.get().setDepartamentosEntity(ciudadesBody.getDepartamentosEntity());
			return ResponseEntity.status(HttpStatus.CREATED).body(ciudadesRepository.save(optionalCiudades.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="/eliminarciudad/{ciudadId}")
	public void eliminarCiudad(@PathVariable(value="ciudadId") Integer ciudadId) {
		ciudadesRepository.deleteById(ciudadId);
	}
}
