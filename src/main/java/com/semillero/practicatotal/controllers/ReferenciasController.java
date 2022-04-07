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

import com.semillero.practicatotal.entidades.ReferenciasEntity;
import com.semillero.practicatotal.repositories.ReferenciasRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/referencias")
public class ReferenciasController {
	
	@Autowired
	private ReferenciasRepository referenciasRepository;
	
	private ReferenciasEntity referencias;
	
	@GetMapping("/listareferencias")
	public List<ReferenciasEntity> obtenerListaReferencias(){
		return referenciasRepository.findAll();
	}
	
	@GetMapping(value="/consultarreferenciabyid/{referenciaId}")
	public ReferenciasEntity obtenerReferenciaById(@PathVariable(value="referenciaId") Integer referenciaId){
		Optional<ReferenciasEntity> referenciasEntity = referenciasRepository.findById(referenciaId);
		return referenciasEntity.get();
	}
	
	@PostMapping(value="/ingresarreferencia", consumes = "application/json")
	public ReferenciasEntity crearReferencia(@RequestBody ReferenciasEntity referenciasEntity) {
		referencias = referenciasRepository.saveAndFlush(referenciasEntity);
		return referencias;
	}
	
	@PutMapping(value="/editarreferencia/{referenciaId}", consumes = "application/json")
	public ResponseEntity<ReferenciasEntity> editarReferencia(@PathVariable(value="referenciaId") Integer referenciaId, @RequestBody ReferenciasEntity referenciasBody) {
		Optional<ReferenciasEntity> referencias = referenciasRepository.findById(referenciaId);
		if(referencias.isPresent()) {
			referencias.get().setStrDominio(referenciasBody.getStrDominio());
			referencias.get().setStrRangoValor(referenciasBody.getStrRangoValor());
			referencias.get().setStrDescripcion(referenciasBody.getStrDescripcion());
			referencias.get().setStrEstado(referenciasBody.getStrEstado());
			return ResponseEntity.status(HttpStatus.CREATED).body(referenciasRepository.save(referencias.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="/eliminarreferenciabyid/{referenciaId}")
	public void eliminarReferenciaById(@PathVariable(value="referenciaId") Integer referenciaId){
		referenciasRepository.deleteById(referenciaId);
	}
}
