package com.picom.initialisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.picom.business.Administrateur;
import com.picom.business.Client;
import com.picom.business.Utilisateur;
import com.picom.dao.AdministrateurDao;
import com.picom.dao.UtilisateurDao;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final UtilisateurDao utilisateurDao;
	private final AdministrateurDao administrateurDao; 

	@Override
	public void run(String... args) throws Exception {
		
		Client clientTest = new Client();
		clientTest.setNom("Eponge2");
		clientTest.setPrenom("Bob");
		clientTest.setMotDePasse("12345678");
		clientTest.setEmail("client1@orsys.fr");
		utilisateurDao.save(clientTest);
		
		Administrateur adminTest = new Administrateur(); 
		adminTest.setNom("Le2"); 
		adminTest.setPrenom("Pape"); 
		adminTest.setMotDePasse("12345789"); 
		adminTest.setEmail("test@orsys.fr");
		administrateurDao.save(adminTest);
		
		

	}
}
