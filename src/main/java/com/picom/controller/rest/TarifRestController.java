package com.picom.controller.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Tarif;
import com.picom.dto.TarifDto;
import com.picom.service.TarifService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class TarifRestController {
	
	private final TarifService tarifService;
	
	@RolesAllowed("ADMIN")
	@GetMapping("ListTarif")
	public List<Tarif> getTarifs(){
		return tarifService.recupererTousLesTarifs();
	}
	
	//@RolesAllowed("ADMIN")	
	@PostMapping(value = "addTarif")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifDto tarifPost(@Valid @RequestBody TarifDto tarifDto, BindingResult result){
		Tarif tarif = new Tarif(); 
		tarif.setPrixEnEuros(tarifDto.getPrixEnEuros());
		//tarif.setAdministrateur(tarifDto.getAdministrateur());
		tarif.setZone(tarifDto.getZone().getId());
		tarif.setTrancheHoraire(tarifDto.getTrancheHoraire().getId());
		tarifService.enregistrerUnTarif(tarifDto);
		return tarifDto; 
		  
	}
	

	

}
