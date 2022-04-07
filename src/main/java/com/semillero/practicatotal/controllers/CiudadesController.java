package com.semillero.practicatotal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semillero.practicatotal.entidades.DepartamentosEntity;
import com.semillero.practicatotal.repositories.DepartamentosRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/ciudades")
public class CiudadesController {

	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	private DepartamentosEntity departamentosEntity;
}
