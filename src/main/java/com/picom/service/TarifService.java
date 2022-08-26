package com.picom.service;

import java.util.List;

import javax.validation.Valid;

import com.picom.business.Tarif;
import com.picom.dto.TarifDto;

public interface TarifService {

	Tarif enregistrerUnTarif (Tarif tarif);
	
	Tarif enregistrerUnTarif(@Valid TarifDto tarifDto);
	
	List<Tarif>recupererTousLesTarifs ();
}
