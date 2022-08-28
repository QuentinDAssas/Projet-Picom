package com.picom.controller.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Tarif;
import com.picom.dto.TarifDto;
import com.picom.service.AdministrateurService;
import com.picom.service.TarifService;
import com.picom.service.TrancheHoraireService;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class TarifRestController {
	
	private final TarifService tarifService;
	private final ZoneService zoneService;
	private final TrancheHoraireService trancheHoraireService;
	private final AdministrateurService administrateurService;
	
	@RolesAllowed("ADMIN")
	@GetMapping("ListTarif")
	public List<Tarif> getTarifs(){
		return tarifService.recupererTousLesTarifs();
	}
	
	@GetMapping("tarif{id}")
	public Tarif getTarif(@PathVariable Long id) {
		return tarifService.recupererTarif(id);
	}
	
//	@RolesAllowed("ADMIN")	
	@PostMapping(value = "addTarif")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifDto tarifPost(@Valid @RequestBody TarifDto tarifDto, BindingResult result){
		System.out.println(tarifDto);
		Tarif tarif = new Tarif(); 
		tarif.setPrixEnEuros(tarifDto.getPrixEnEuros());
		tarif.setAdministrateur(administrateurService.recupererAdministrateur(tarifDto.getIdAdministrateur()));
		tarif.setZone(zoneService.recupererZone(tarifDto.getIdZone()));
		tarif.setTrancheHoraire(trancheHoraireService.recupererTrancheHoraire(tarifDto.getIdTrancheHoraire()));
		System.out.println(tarifDto);
		tarifService.enregistrerUnTarif(tarif);
		return tarifDto; 
		  
	}
	
	@DeleteMapping("deleteTarif{id}")
	public boolean deleteTarif(@PathVariable Long id) {
		return tarifService.supprimerTarif(id);
	}

}