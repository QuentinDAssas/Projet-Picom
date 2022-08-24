package com.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picom.business.Administrateur;
import com.picom.business.Tarif;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;

public interface AdministrateurDao extends JpaRepository<Administrateur, Long>{
	


}
