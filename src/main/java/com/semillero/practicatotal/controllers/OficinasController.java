package com.semillero.practicatotal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/listaoficinas")
	public List<OficinasEntity> obtenerListaOficinas() {
		return oficinasRepository.findAll();
	}
	
	@GetMapping("/oficinabyid/{oficinaId}")
	public OficinasEntity obtenerOficinaById(@PathVariable(value="oficinaId") Integer oficinaId){
		Optional<OficinasEntity> oficinasOptional = oficinasRepository.findById(oficinaId);
		return oficinasOptional.get();
	}
	
	@PostMapping(value="/ingresaroficina", consumes="application/json")
	public OficinasEntity ingresarOficina(@RequestBody OficinasEntity oficinasBody) {
		oficinasEntity = oficinasRepository.saveAndFlush(oficinasBody);
		return oficinasEntity;
	}
}
