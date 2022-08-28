package com.picom.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.picom.business.Tarif;
import com.picom.dao.TarifDao;
import com.picom.dto.TarifDto;
import com.picom.service.AdministrateurService;
import com.picom.service.TarifService;
import com.picom.service.TrancheHoraireService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TarifServiceImpl implements TarifService {

	TarifDao tarifDao;
	private final ZoneService zoneService;
	private final TrancheHoraireService trancheHoraireService;
	private final AdministrateurService administrateurService;

	@Override
	public Tarif enregistrerUnTarif(Tarif tarif) {
		return tarifDao.save(tarif);
	}

	@Override
	public Tarif recupererTarif(Long id) {
		return tarifDao.findById(id).orElse(null);
	}

	@Override
	public Tarif enregistrerUnTarif(@Valid TarifDto tarifDto) {
		Tarif tarif = new Tarif();
		tarif.setPrixEnEuros(tarifDto.getPrixEnEuros());
		tarif.setAdministrateur(administrateurService.recupererAdministrateur(tarifDto.getIdAdministrateur()));
		tarif.setZone(zoneService.recupererZone(tarifDto.getIdZone()));
		tarif.setTrancheHoraire(trancheHoraireService.recupererTrancheHoraire(tarifDto.getIdTrancheHoraire()));
		tarifDao.save(tarif);
		return tarif;
	}

	@Override
	public List<Tarif> recupererTousLesTarifs() {
		return tarifDao.findAll();
	}

	@Override
	public boolean supprimerTarif(Long id) {
		Tarif tarif = recupererTarif(id);
		if (tarif == null) {
			return false;
		} else {
			tarifDao.deleteById(id);
			return true;
		}

	}
}
