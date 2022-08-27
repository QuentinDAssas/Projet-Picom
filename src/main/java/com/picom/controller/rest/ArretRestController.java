package com.picom.controller.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Arret;
import com.picom.service.ArretService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/")
@AllArgsConstructor
@Validated
public class ArretRestController {

	private final ArretService arretService;

	@RolesAllowed("CLIENT")
	@GetMapping("arrets")
	public List<Arret> getArrets() {
		return arretService.recupererListeArrets();
	}
}
