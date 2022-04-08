package com.semillero.practicatotal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
