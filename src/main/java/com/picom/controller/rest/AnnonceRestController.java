package com.picom.controller.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Annonce;
import com.picom.business.TrancheHoraire;
import com.picom.service.AnnonceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/")
public class AnnonceRestController {
	
	private final AnnonceService annonceService; 
	
	@RolesAllowed("CLIENT")
	@GetMapping("annonces")
	public List<Annonce> annoncesGetAll(){
		return annonceService.recupererListeAnnonces();
	}
	
	@RolesAllowed("CLIENT")
	@GetMapping("annonces/{id}")
	public Annonce annoncesGet(@PathVariable Long id){
		return annonceService.recupererAnnonce(id);
	}
	
	@RolesAllowed("CLIENT")
	@GetMapping("annonces/{id}/tranchesHoraires")
    public List<TrancheHoraire> tranchesHorairesAnnoncesGet(@PathVariable Long id){
        return annonceService.recupererAnnonce(id).getTranchesHoraires();
    }
	
	@RolesAllowed("CLIENT")
	@PostMapping("annonces")
	public Annonce annoncePost(@Valid Annonce annonce){
		return annonceService.enregistrerAnnonce(annonce);
	}
	
	@RolesAllowed("CLIENT")
	@DeleteMapping("annonces/{id}")
	public boolean annonceDelete(@PathVariable Long id){
		return annonceService.supprimerAnnonce(id);
	}
	
	@RolesAllowed("CLIENT")
	@PutMapping("annonces/{id}")
	public Annonce annoncePut(@RequestBody Annonce annonce){
		// annonce = annonceService.recupererAnnonce(id);
		
		return annonceService.modifierAnnonce(annonce.getDateHeureDebut(),annonce.getDateHeureFin(),annonce.getContenu(),annonce.getZones(),annonce.getTranchesHoraires());
	}
	
	
}
