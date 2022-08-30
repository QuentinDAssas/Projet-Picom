package com.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.picom.business.Arret;
import com.picom.business.Zone;
import com.picom.dao.ArretDao;
import com.picom.service.ArretService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArretServiceImpl implements ArretService{
	
	private ArretDao arretDao;


	@Override
	public boolean supprimerArret(long id) {
		arretDao.deleteById(id);
		return true;
	}

	@Override
	public Arret modifierArret(String nom, double longitude, double latitude, Zone zone) {
		Arret arret = new Arret(); 
		arret.setNom(nom);
		arret.setLongitude(longitude);
		arret.setLatitude(latitude);
		arret.setZone(zone);
		return arretDao.save(arret);
	}

	@Override
	public Arret recupererArret(long id) {
		return arretDao.findById(id).orElse(null);
	}

	@Override
	public List<Arret> recupererListeArrets() {
		return arretDao.findAll();
	}

}
