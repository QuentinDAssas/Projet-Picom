package com.picom.controller.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Utilisateur;
import com.picom.service.UtilisateurService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Validated
public class UtilisateurRestController {
	
	private final UtilisateurService utilisateurService;
	
	
    @GetMapping("utilisateurs/login")
    public ResponseEntity<Utilisateur> utilisateurGetByEmailAndMotDePasse(@PathVariable String email, @PathVariable String motDePasse) throws URISyntaxException {
        Utilisateur u = utilisateurService.recupererUtilisateur(email, motDePasse);
        
        if(u.getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        
        return ResponseEntity.created(new URI("/api/utilisateurs/" + email + "/" + motDePasse)).body(u);
    }

}
