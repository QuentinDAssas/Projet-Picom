package com.picom.service;

import com.picom.business.Utilisateur;
import com.picom.dto.UtilisateurDto;

public interface UtilisateurService {
	
	Utilisateur recupererUtilisateur(String email, String motDePasse);
	
	Utilisateur recupererUtilisateur(String email);
	
}
