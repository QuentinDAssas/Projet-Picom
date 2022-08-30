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
import com.picom.service.ClientService;
import com.picom.service.TarifService;
import com.picom.service.TrancheHoraireService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnnonceServiceImpl implements AnnonceService {

	private AnnonceDao annonceDao;
	private final TarifService tarifService;
	private final ZoneService zoneService;
	private final TrancheHoraireService trancheHoraireService;
	private final ClientService clientService;

	@Override
	public Annonce enregistrerAnnonce(@Valid Annonce annonce) {
		Annonce newAnnonce = new Annonce();
		newAnnonce.setDateHeureCreation(annonce.getDateHeureCreation());
		newAnnonce.setDateHeureDebut(annonce.getDateHeureDebut());
		newAnnonce.setDateHeureFin(annonce.getDateHeureFin());
		newAnnonce.setContenu(annonce.getContenu());
		newAnnonce.setNumeroCarte(annonce.getNumeroCarte());
		newAnnonce.setAnneeExpiration(annonce.getAnneeExpiration());
		newAnnonce.setMoisExpiration(annonce.getMoisExpiration());
		newAnnonce.setCryptogramme(annonce.getCryptogramme());
		newAnnonce.setClient(annonce.getClient());
		newAnnonce.setZones(zoneService.recupererListeZones());
		newAnnonce.setTranchesHoraires(trancheHoraireService.recupererListeTrancheHoraire());
		newAnnonce.setMontantRegleEnEuros(annonce.getMontantRegleEnEuros());
		return annonceDao.save(newAnnonce);
	}

	@Override
	public boolean supprimerAnnonce(long id) {
		annonceDao.deleteById(id);
		return true;
	}

	@Override
	public Annonce modifierAnnonce(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, String contenu,
			List<Zone> zones, List<TrancheHoraire> tranchesHoraires) {
		Annonce annonce = new Annonce();
		annonce.setDateHeureDebut(dateHeureDebut);
		annonce.setDateHeureFin(dateHeureFin);
		annonce.setContenu(contenu);
		annonce.setZones(zones);
		annonce.setTranchesHoraires(tranchesHoraires);
		annonceDao.save(annonce);
		return annonce;
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
