package com.picom.service;

import java.util.List;

import com.picom.business.Tarif;

public interface TarifService {

	Tarif enregistrerUnTarif (Tarif tarif);
	
	List<Tarif> TousLesTarifs (Tarif tarif);
}
