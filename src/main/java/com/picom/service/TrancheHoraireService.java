package com.picom.service;

import java.util.List;

import com.picom.business.TrancheHoraire;

public interface TrancheHoraireService {
	
	TrancheHoraire recupererTrancheHoraire(long id);
	
	List<TrancheHoraire>recupererListeTrancheHoraire();
}
