package com.picom.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.picom.business.Annonce;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dao.AnnonceDao;
import com.picom.dto.AnnonceDto;
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
	public Annonce enregistrerAnnonce(@Valid AnnonceDto annonceDto) {
		Annonce annonce = new Annonce();
		annonce.setDateHeureCreation(annonce.getDateHeureCreation());
		annonce.setDateHeureDebut(annonceDto.getDateHeureDebut());
		annonce.setDateHeureFin(annonceDto.getDateHeureFin());
		annonce.setContenu(annonceDto.getContenu());
		annonce.setNumeroCarte(annonceDto.getNumeroCarte());
		annonce.setAnneeExpiration(annonceDto.getAnneeExpiration());
		annonce.setMoisExpiration(annonceDto.getMoisExpiration());
		annonce.setCryptogramme(annonceDto.getCryptogramme());
		annonce.setClient(clientService.recupererClient(annonceDto.getIdClient()));
		List<Zone> zones = new ArrayList<>();
        annonceDto.getIdZoneAnnonce().forEach(item -> {
        	zones.add(zoneService.recupererZone(item));
        });
        annonce.setZones(zones);
		List<TrancheHoraire> tranches = new ArrayList<>();
        annonceDto.getIdTrancheHoraireAnnonce().forEach(item -> {
            tranches.add(trancheHoraireService.recupererTrancheHoraire(item));
        });
        annonce.setTranchesHoraires(tranches);
        annonce.setMontantRegleEnEuros(annonceDto.getMontantRegleEnEuros());
		return annonceDao.save(annonce);
	}

	@Override
	public boolean supprimerAnnonce(long id) {
		annonceDao.deleteById(id);
		return true;
	}

	@Override
	public Annonce modifierAnnonce(LocalDate dateHeureDebut, LocalDate dateHeureFin, String contenu,
			List<Zone>zones, List<TrancheHoraire> tranchesHoraires) {
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
