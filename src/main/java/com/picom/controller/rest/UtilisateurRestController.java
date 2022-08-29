package com.picom.controller.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.TrancheHoraire;
import com.picom.business.Utilisateur;
import com.picom.business.Zone;
import com.picom.service.TrancheHoraireService;
import com.picom.service.UtilisateurService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@Validated
public class UtilisateurRestController {
	
	private final UtilisateurService utilisateurService;
	private final ZoneService zoneService;
	private final TrancheHoraireService trancheHoraireService;
	
	@GetMapping("index/{email}/{motDePasse}")
    public Utilisateur utilisateurGetByEmailAndMotDePasse(@PathVariable String email, @PathVariable String motDePasse) {
		System.out.println(email + "/" + motDePasse);
        return utilisateurService.recupererUtilisateur(email, motDePasse);
    }
    
    @GetMapping("zones")
    public List<Zone> getZones(){
    	return zoneService.recupererListeZones();
    }
    
    @GetMapping("trancheHoraires")
    public List<TrancheHoraire> getTrancheHoraire(){
    	return trancheHoraireService.recupererListeTrancheHoraire();
    }
    
	protected Utilisateur recupererUtilisateur() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return utilisateurService.recupererUtilisateur(user.getUsername());
	}

}
