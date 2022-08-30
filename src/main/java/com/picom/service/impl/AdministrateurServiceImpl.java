package com.picom.service.impl;

import org.springframework.stereotype.Service;

import com.picom.business.Administrateur;
import com.picom.dao.AdministrateurDao;
import com.picom.service.AdministrateurService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdministrateurServiceImpl implements AdministrateurService {
	
	private AdministrateurDao administrateurDao;

	@Override
	public Administrateur recupererAdministrateur(Long id) {
		return administrateurDao.findById(id).orElse(null);
	}
	

}	
