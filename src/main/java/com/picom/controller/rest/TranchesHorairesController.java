package com.picom.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.TrancheHoraire;
import com.picom.service.TrancheHoraireService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/")
@AllArgsConstructor
@Validated
public class TranchesHorairesController {
	private final TrancheHoraireService trancheHoraireService;

	@GetMapping("trancheHoraires")
	public List<TrancheHoraire> getTrancheHoraire() {
		return trancheHoraireService.recupererListeTrancheHoraire();
	}
}
