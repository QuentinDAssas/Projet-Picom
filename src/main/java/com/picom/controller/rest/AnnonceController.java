package com.picom.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Annonce;
import com.picom.service.AnnonceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
public class AnnonceController {
	
	private final AnnonceService annonceService; 
	
	
	@GetMapping("annonces")
	public List<Annonce> annoncesGet() {
		return annonceService.recupererListeAnnonces();
	}
	
	@PostMapping("annonces")
	public Annonce annoncePost(@Valid Annonce annonce) {
		return annonceService.enregistrerAnnonce(annonce);
	}
	
	@DeleteMapping("annonces/{id}")
	public boolean annonceDelete(@PathVariable Long id) {
		return annonceService.supprimerAnnonce(id);
	}
	
	@PutMapping("{id}")
	public Annonce annoncePut(@RequestBody Annonce annonce) {
		// annonce = annonceService.recupererAnnonce(id);
		
		return annonceService.modifierAnnonce(annonce.getDateHeureDebut(),annonce.getDateHeureFin(),annonce.getContenu(),annonce.getZones(),annonce.getTranchesHoraires());
	}
	
	
}
