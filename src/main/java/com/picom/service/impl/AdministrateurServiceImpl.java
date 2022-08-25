package com.picom.service.impl;

import com.picom.business.Administrateur;
import com.picom.dao.AdministrateurDao;
import com.picom.service.AdministrateurService;

public class AdministrateurServiceImpl implements AdministrateurService {
	
	private AdministrateurDao administrateurDao;

	@Override
	public Administrateur recupererAdministrateur(Long id) {
		return administrateurDao.findById(id).orElse(null);
	}
	

}	
