package com.picom.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.picom.business.Annonce;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dto.AnnonceDto;

public interface AnnonceService {

	Annonce enregistrerAnnonce(@Valid AnnonceDto annonceDto);
	
	boolean supprimerAnnonce(long id); 
	
	Annonce modifierAnnonce(LocalDate dateHeureDebut, LocalDate dateHeureFin,String contenu,List<Zone>zones,List<TrancheHoraire>tranchesHoraires);

	Annonce recupererAnnonce(long id); 
	
	List<Annonce> recupererListeAnnonces();	
}
