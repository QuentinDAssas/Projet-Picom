package com.picom.initialisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.picom.business.Administrateur;
import com.picom.business.Utilisateur;
import com.picom.dao.AdministrateurDao;
import com.picom.dao.UtilisateurDao;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner{
	
	private final UtilisateurDao utilisateurDao;
	
	@Override
	public void run(String... args) throws Exception {
		Utilisateur userTest = new Utilisateur();
		userTest.setNom("Orsys");
		userTest.setPrenom("jury");
		userTest.setMotDePasse("12345678");
		userTest.setEmail("client1@orsys.fr");
		utilisateurDao.save(userTest);
		
		Utilisateur adminTest = new Utilisateur();
		adminTest.setNom("Eponge");
		adminTest.setPrenom("Bob");
		adminTest.setMotDePasse("12345678");
		adminTest.setEmail("client1@orsys.fr");
		utilisateurDao.save(adminTest);
		
	}

}
