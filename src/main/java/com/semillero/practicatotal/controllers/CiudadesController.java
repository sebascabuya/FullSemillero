package com.semillero.practicatotal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(value="/ingresarciudades", consumes = "application/json")
	public CiudadesEntity ingresarCiudades(@RequestBody CiudadesEntity ciudadesBody) {
		ciudadesEntity = ciudadesRepository.saveAndFlush(ciudadesBody);
		return ciudadesEntity;
	}
}
