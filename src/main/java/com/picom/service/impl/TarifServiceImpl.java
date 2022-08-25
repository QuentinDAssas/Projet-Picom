package com.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.picom.business.Tarif;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dao.TarifDao;
import com.picom.dto.TarifDto;
import com.picom.service.TarifService;
import com.picom.service.TrancheHoraireService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TarifServiceImpl implements TarifService{
	
	TarifDao tarifDao;
	
	@Override
	public Tarif enregistrerUnTarif(Tarif tarif) {
		return tarifDao.save(tarif);
	}
	
	@Override
	public Tarif enregistrerUnTarif(TarifDto tarifDto) {
		Tarif tarif = new Tarif(); 
		tarif.setPrixEnEuros(tarifDto.getPrixEnEuros());
		tarif.setAdministrateur(tarifDto.getAdministrateur());
		tarif.setZone(tarifDto.getZone());
		tarif.setTrancheHoraire(tarifDto.getTrancheHoraire());
		tarifDao.save(tarif);
		return tarif;
	}

	@Override
	public List<Tarif> recupererTousLesTarifs() {
		return tarifDao.findAll();
	}


}
