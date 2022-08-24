package com.picom.service.impl;

import org.springframework.stereotype.Service;

import com.picom.business.TrancheHoraire;
import com.picom.dao.TrancheHoraireDao;
import com.picom.service.TrancheHoraireService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrancheHoraireServiceImpl implements TrancheHoraireService{
	
	TrancheHoraireDao trancheHoraireDao;
	

	@Override
	public TrancheHoraire recupererTrancheHoraire(long id) {
		return trancheHoraireDao.findById(id).orElse(null);
	}

}