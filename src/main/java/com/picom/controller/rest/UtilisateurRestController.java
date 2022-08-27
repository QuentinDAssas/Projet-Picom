package com.picom.controller.rest;

import java.security.Principal;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Utilisateur;
import com.picom.service.UtilisateurService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/")
@AllArgsConstructor
@Validated
public class UtilisateurRestController {
	
	private final UtilisateurService utilisateurService;
	private final UserDetailsService userDetailsService;

	// méthode qui récupère un utilisateur pour l'authentification
	 
	  @RequestMapping("/login")
	  public Utilisateur utilisateurConnexionGet(@PathVariable String email, @PathVariable String motDePasse) {
		  Utilisateur u = utilisateurService.recupererUtilisateur(email, motDePasse);
		 
		  userDetailsService.loadUserByUsername(u.getEmail());
     
		  System.out.println(u);
		  
		  return u; 
		 
	  }

}
	
	
