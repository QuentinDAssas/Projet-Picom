package com.picom.service;

import java.time.LocalDateTime;
import java.util.List;

import com.picom.business.Annonce;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;

public interface AnnonceService {

	Annonce ajouterAnnonce(Annonce annonce);
	
	boolean supprimerAnnonce(long id); 
	
	Annonce modifierAnnonce(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin,String contenu,List<Zone>zones,List<TrancheHoraire>tranchesHoraires);

	Annonce recupererAnnonce(long id); 
	
	List<Annonce> recupererListeAnnonce();
	
	Annonce sauvegarderAnnonce(Annonce annonce);
	
}
