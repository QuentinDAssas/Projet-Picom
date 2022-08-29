package com.picom.controller.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.TrancheHoraire;
import com.picom.business.Utilisateur;
import com.picom.business.Zone;
import com.picom.dto.TarifDto;
import com.picom.dto.UtilisateurDto;
import com.picom.service.TrancheHoraireService;
import com.picom.service.UtilisateurService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("api/")
@AllArgsConstructor
@Validated
public class UtilisateurRestController {
	
	private final UtilisateurService utilisateurService;
	private final ZoneService zoneService;
	private final TrancheHoraireService trancheHoraireService;
	private final UserDetailsService userDetailsService;
	
//    @GetMapping("login")
//    public ResponseEntity<Utilisateur> utilisateurGetByEmailAndMotDePasse(@PathVariable String email, @PathVariable String motDePasse) throws URISyntaxException {
//        Utilisateur u = utilisateurService.recupererUtilisateur(email, motDePasse);
//        
//        if(u.getId() == null) {
//            return ResponseEntity.badRequest().body(null);
//        }
//        
//        return ResponseEntity.created(new URI("/api/utilisateurs/" + email + "/" + motDePasse)).body(u);
//    }
    

	// méthode qui récupère un utilisateur pour l'authentification
	 
	  @RequestMapping("login")
	  public Utilisateur utilisateurConnexionGet(@PathVariable String email, @PathVariable String motDePasse) {
		  Utilisateur u = utilisateurService.recupererUtilisateur(email, motDePasse);
		 
		  userDetailsService.loadUserByUsername(u.getEmail());
     
		  System.out.println(u);
		  
		  return u; 
		 
	  }  

	  
    @GetMapping("zones")
    public List<Zone> getZones(){
    	return zoneService.recupererListeZones();
    }
    
    @GetMapping("trancheHoraires")
    public List<TrancheHoraire> getTrancheHoraire(){
    	return trancheHoraireService.recupererListeTrancheHoraire();
    }

}
