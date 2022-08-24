package com.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picom.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{

}
