package com.picom.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Tarif;
import com.picom.dto.TarifDto;
import com.picom.service.TarifService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("api/")
public class TarifRestController {
	
	private final TarifService tarifService;
	
	
	@GetMapping("tarifs")
	public List<Tarif> tarifsGet(){
		return tarifService.recupererTousLesTarifs();
	}
	
	@PostMapping("tarifsDto")
	public TarifDto tarifPost(TarifDto tarifDto){
		Tarif tarif = new Tarif(); 
		tarif.setPrixEnEuros(tarifDto.getPrixEnEuros());
		tarif.setAdministrateur(tarifDto.getAdministrateur());
		tarif.setZone(tarifDto.getZone());
		tarif.setTrancheHoraire(tarifDto.getTrancheHoraire());
		tarifService.enregistrerUnTarif(tarifDto);
		return tarifDto; 
		  
	}
	
	
	

}
