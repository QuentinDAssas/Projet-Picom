package com.picom.service.impl;

import org.springframework.stereotype.Service;

import com.picom.dao.DiffusionDao;
import com.picom.service.DiffusionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiffusionServiceImpl implements DiffusionService{

	private DiffusionDao diffusionDao; 
	
}
