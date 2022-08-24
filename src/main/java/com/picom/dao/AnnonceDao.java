package com.picom.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picom.business.Annonce;

public interface AnnonceDao extends JpaRepository<Annonce, Long> {

	Annonce findByDateHeureDebut(LocalDateTime dateHeureDebut);
	
}
	
