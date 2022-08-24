package com.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.picom.business.Annonce;
import com.picom.business.Arret;
import com.picom.business.Zone;
import com.picom.dao.ZoneDao;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZoneServiceImpl implements ZoneService{

	private ZoneDao zoneDao;

	@Override
	public boolean supprimerZone(long id) {
		zoneDao.deleteById(id);
		return true; 
	}

	@Override
	public Zone modifierZone(String nom, List<Arret> arrets, List<Annonce> annonces) {
		Zone zone = new Zone(); 
		zone.setNom(nom); 
		zone.setArrets(arrets);
		zone.setAnnonces(annonces);
		return zoneDao.save(zone);
	}

	@Override
	public Zone recupererZone(long id) {
		return zoneDao.findById(id).orElse(null);
	}

	@Override
	public List<Zone> recupererListeZones() {
		return zoneDao.findAll();
	}


}
