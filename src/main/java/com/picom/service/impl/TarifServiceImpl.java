package com.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.picom.business.Tarif;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dao.TarifDao;
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
	public List<Tarif> TousLesTarifs(Tarif tarif) {
		return tarifDao.findAll();
	}

}
