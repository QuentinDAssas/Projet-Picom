package com.picom.controller.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picom.service.TarifService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8180/", maxAge = 3600)
@RestController
@RequestMapping("api/)")
public class TarifRestController {
	
	private final TarifService tarifService;

}
