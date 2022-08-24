package com.picom.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

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
	public Annonce enregistrerAnnonce(@Valid Annonce annonce) {
		return annonceDao.save(annonce);
	}

	@Override
	public boolean supprimerAnnonce(long id) {
		annonceDao.deleteById(id);
		return true; 
	}

	@Override
	public Annonce modifierAnnonce(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, String contenu,
			List<Zone>zones, List<TrancheHoraire> tranchesHoraires) {
		Annonce annonce = new Annonce(); 
		annonce.setDateHeureDebut(dateHeureDebut); 
		annonce.setDateHeureFin(dateHeureFin);
		annonce.setContenu(contenu); 
		annonce.setZones(zones);
		annonce.setTranchesHoraires(tranchesHoraires);
		return annonceDao.save(annonce);
	}

	@Override
	public Annonce recupererAnnonce(long id) {
		return annonceDao.findById(id).orElse(null);
	}

	@Override
	public List<Annonce> recupererListeAnnonces() {
		return annonceDao.findAll();
	}


}
