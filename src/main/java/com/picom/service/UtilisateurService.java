package com.picom.service;

import javax.validation.Valid;

import com.picom.business.Utilisateur;

public interface UtilisateurService {
	
	Utilisateur enregistrerUtilisateur(@Valid Utilisateur utilisateur);

}
