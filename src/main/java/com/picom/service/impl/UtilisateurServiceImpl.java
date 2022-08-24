package com.picom.service.impl;

import org.springframework.stereotype.Service;

import com.picom.business.Utilisateur;
import com.picom.dao.UtilisateurDao;
import com.picom.service.UtilisateurService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private UtilisateurDao utilisateurDao;

	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findByEmailAndMotDePasse(email, motDePasse);
	}

}
