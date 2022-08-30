package com.picom.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.picom.business.Annonce;
import com.picom.business.Arret;
import com.picom.business.Diffusion;
import com.picom.dao.DiffusionDao;
import com.picom.service.DiffusionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiffusionServiceImpl implements DiffusionService {

	private DiffusionDao diffusionDao;

	@Override
	public Diffusion enregistrerDiffusion(@Valid Diffusion diffusion) {
		return diffusionDao.save(diffusion);
	}

	@Override
	public boolean supprimerDiffusion(long id) {
		diffusionDao.deleteById(id);
		return true;
	}

	@Override
	public Diffusion modifierDiffusion(LocalDateTime dateHeureDiffusion, Arret arret, Annonce annonce) {
		Diffusion diffusion = new Diffusion();
		diffusion.setDateHeureDiffusion(dateHeureDiffusion);
		diffusion.setArret(arret);
		diffusion.setAnnonce(annonce);
		return diffusionDao.save(diffusion);
	}

	@Override
	public Diffusion recupererDiffusion(long id) {
		return diffusionDao.findById(id).orElse(null);
	}

	@Override
	public List<Diffusion> recupererListeDiffusions() {
		return diffusionDao.findAll();
	}

}
