package com.picom.controller.rest;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// import classe métier
import com.picom.business.Annonce;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;

// import classe Dto
import com.picom.dto.AnnonceDto;

// import service
import com.picom.service.AnnonceService;
import com.picom.service.ClientService;
import com.picom.service.TrancheHoraireService;
import com.picom.service.UtilisateurService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class AnnonceRestController {
	
	private final AnnonceService annonceService;
	private final ClientService clientService;
	private final ZoneService zoneService;
	private final TrancheHoraireService trancheHoraireService;
	private final UtilisateurService utilisateurService;
	
	
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
	@PostMapping(value = "addAnnonce")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Annonce annoncePost(@Valid @RequestBody AnnonceDto annonceDto, BindingResult result){
		Annonce annonce = new Annonce();
		annonce.setDateHeureCreation(annonce.getDateHeureCreation());
		annonce.setDateHeureDebut(annonceDto.getDateHeureDebut());
		annonce.setDateHeureFin(annonceDto.getDateHeureFin());
		annonce.setContenu(annonceDto.getContenu());
		annonce.setNumeroCarte(annonceDto.getNumeroCarte());
		annonce.setAnneeExpiration(annonceDto.getAnneeExpiration());
		annonce.setMoisExpiration(annonceDto.getMoisExpiration());
		annonce.setCryptogramme(annonceDto.getCryptogramme());
		annonce.setClient(clientService.recupererClient(annonceDto.getIdClient()));
		List<Zone> zones = new ArrayList<>();
        annonceDto.getIdZoneAnnonce().forEach(item -> {
        	zones.add(zoneService.recupererZone(item));
        });
        annonce.setZones(zones);
		List<TrancheHoraire> tranches = new ArrayList<>();
        annonceDto.getIdTrancheHoraireAnnonce().forEach(item -> {
            tranches.add(trancheHoraireService.recupererTrancheHoraire(item));
        });
        annonce.setTranchesHoraires(tranches);
		annonce.setMontantRegleEnEuros(annonceDto.getMontantRegleEnEuros());
		annonceService.enregistrerAnnonce(annonce);
		return annonce;
	}
	
	@RolesAllowed("CLIENT")
	@DeleteMapping("annonces/{id}")
	public boolean annonceDelete(@PathVariable Long id){
		return annonceService.supprimerAnnonce(id);
	}
	
	@RolesAllowed("CLIENT")
	@PutMapping("annonces/{id}")
	public Annonce annoncePut(@RequestBody Annonce annonce){
		 Annonce uptdate = new Annonce();
		 uptdate = annonceService.recupererAnnonce(annonce.getId());
		return null;
	}
		
}
