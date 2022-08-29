package com.picom.controller.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Diffusion;
import com.picom.service.DiffusionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/)")
@Validated
public class DiffusionRestController {
	
	private final DiffusionService diffusionService; 
	
	@RolesAllowed("CLIENT")
	@GetMapping("diffusions")
	public List<Diffusion> diffusionsGet(){
		return diffusionService.recupererListeDiffusions();
	}
	@RolesAllowed("CLIENT")
	@PostMapping("diffusions")
	public Diffusion diffusionPost(@Valid Diffusion diffusion) {
		return diffusionService.enregistrerDiffusion(diffusion);
	}
	
	
}
