package com.picom.service;

import javax.validation.Valid;

import com.picom.business.Utilisateur;
import com.picom.dto.UtilisateurDto;

public interface UtilisateurService {
	
	Utilisateur recupererUtilisateur(String email, String motDePasse);
	
	Utilisateur recupererUtilisateur(@Valid UtilisateurDto utilisateurDto);
}
