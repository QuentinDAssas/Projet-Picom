package com.picom.service.impl;

import javax.validation.Valid;

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
	public Utilisateur enregistrerUtilisateur(@Valid Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

}
