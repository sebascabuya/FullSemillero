package com.semillero.practicatotal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semillero.practicatotal.entidades.OficinasEntity;
import com.semillero.practicatotal.repositories.OficinasRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/oficinas")
public class OficinasController {

	@Autowired
	private OficinasRepository oficinasRepository;
	
	private OficinasEntity oficinasEntity;
	private Optional<OficinasEntity> oficinasOptional;
	
	@GetMapping("/listaoficinas")
	public List<OficinasEntity> obtenerListaOficinas() {
		return oficinasRepository.findAll();
	}
	
	@GetMapping("/oficinabyid/{oficinaId}")
	public OficinasEntity obtenerOficinaById(@PathVariable(value="oficinaId") Integer oficinaId){
		oficinasOptional = oficinasRepository.findById(oficinaId);
		return oficinasOptional.get();
	}
	
	@PostMapping(value="/ingresaroficina", consumes="application/json")
	public OficinasEntity ingresarOficina(@RequestBody OficinasEntity oficinasBody) {
		oficinasEntity = oficinasRepository.saveAndFlush(oficinasBody);
		return oficinasEntity;
	}
	
	@PutMapping(value="/actualizaroficina/{oficinaId}", consumes="application/json")
	public ResponseEntity<OficinasEntity> actualizarOficinas(@PathVariable(value="oficinaId") Integer oficinaId, @RequestBody OficinasEntity oficinasBody){
		oficinasOptional = oficinasRepository.findById(oficinaId);
		if(oficinasOptional.isPresent()) {
			oficinasOptional.get().setStrCodigoOficina(oficinasBody.getStrCodigoOficina());
			oficinasOptional.get().setStrNombreOficina(oficinasBody.getStrNombreOficina());
			oficinasOptional.get().setStrDireccionOficina(oficinasBody.getStrDireccionOficina());
			oficinasOptional.get().setCiudadesEntity(oficinasBody.getCiudadesEntity());
			return ResponseEntity.status(HttpStatus.CREATED).body(oficinasRepository.save(oficinasOptional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
