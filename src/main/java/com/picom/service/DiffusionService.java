package com.picom.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import com.picom.business.Annonce;
import com.picom.business.Arret;
import com.picom.business.Diffusion;

public interface DiffusionService {

	Diffusion enregistrerDiffusion(@Valid Diffusion diffusion);
	
	boolean supprimerDiffusion(long id); 
	
	Diffusion modifierDiffusion(LocalDateTime dateHeureDiffusion, Arret arret, Annonce annonce);
	
	Diffusion recupererDiffusion(long id);
	
	List<Diffusion> recupererListeDiffusions();

}
