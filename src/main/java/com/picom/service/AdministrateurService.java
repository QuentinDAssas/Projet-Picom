package com.picom.service;

import javax.validation.Valid;

import com.picom.business.Administrateur;

public interface AdministrateurService {
	
	Administrateur enregistrerAdministrateur(@Valid Administrateur administrateur);

}
