package com.picom.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Zone;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;


@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/")
@AllArgsConstructor
@Validated
public class ZoneRestController {

	private final ZoneService zoneService;
	
	 @GetMapping("zones")
	    public List<Zone> getZones(){
	    	return zoneService.recupererListeZones();
	    }
}
