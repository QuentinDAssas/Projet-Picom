package com.picom.service;

import com.picom.business.Tarif;

public interface TarifService {

	Tarif enregistrerUnTarif (Tarif tarif);
	
	Tarif recupererTarif(Long idZone, Long idTrancheHoraire);
	
}
