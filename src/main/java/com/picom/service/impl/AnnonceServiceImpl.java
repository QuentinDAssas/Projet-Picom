package com.picom.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.picom.business.Annonce;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dao.AnnonceDao;
import com.picom.service.AnnonceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnnonceServiceImpl implements AnnonceService{
	
	private AnnonceDao annonceDao; 
	
	@Override
	public Annonce ajouterAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimerAnnonce(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Annonce modifierAnnonce(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, String contenu,
			List<Zone> zones, List<TrancheHoraire> tranchesHoraires) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annonce recupererAnnonce(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annonce> recupererListeAnnonce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annonce sauvegarderAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		return null;
	}

}
