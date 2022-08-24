package com.picom.service;

import java.util.List;

import com.picom.business.Arret;
import com.picom.business.Zone;

public interface ArretService {
	
	boolean supprimerArret(long id); 
	
	Arret modifierArret(String nom,double longitude, double latitude, Zone zone );
	
	Arret recupererArret(long id); 
	
	List<Arret>recupererListeArrets(); 
	
}
