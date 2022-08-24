package com.picom.service;

import java.util.List;

import com.picom.business.Annonce;
import com.picom.business.Arret;
import com.picom.business.Zone;

public interface ZoneService {
	
	boolean supprimerZone(long id); 
	
	Zone modifierZone(String nom, List<Arret>arrets,List<Annonce>annonces);
	
	Zone recupererZone(long id); 
	
	List<Zone>recupererListeZones();

}
