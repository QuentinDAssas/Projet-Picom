package com.picom.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.picom.business.Utilisateur;

public interface UtilisateurService {
	
	Utilisateur recupererUtilisateur(String email, String motDePasse);
	
}
