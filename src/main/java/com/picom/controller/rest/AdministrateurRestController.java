package com.picom.controller.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Administrateur;
import com.picom.service.AdministrateurService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = ("http://localhost:4200"), maxAge = 3600)
@RestController
@RequestMapping("api/)")
public class AdministrateurRestController {
	
	private final AdministrateurService administrateurService;
	
	@GetMapping("administrateur/{id}")
	public Administrateur administrateurGet(@PathVariable Long id) {
		return administrateurService.recupererAdministrateur(id);
	}

}
