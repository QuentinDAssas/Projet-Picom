package com.picom.initialisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.picom.business.Administrateur;
import com.picom.business.Client;
import com.picom.dao.AdministrateurDao;
import com.picom.dao.ClientDao;
import com.picom.dao.UtilisateurDao;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final AdministrateurDao administrateurDao; 
	private final ClientDao clientDao;

	@Override
	public void run(String... args) throws Exception {
		
	
		Client clientTest = new Client();
		clientTest.setNom("Orsys");
		clientTest.setPrenom("jury");
		clientTest.setMotDePasse("12345678");
		clientTest.setEmail("client1@orsys.fr");
		clientTest.setNumeroDeTelephone("02 40 35 06 70");
		clientDao.save(clientTest);

		Administrateur adminTest = new Administrateur();
		adminTest.setNom("Eponge");
		adminTest.setPrenom("Bob");
		adminTest.setMotDePasse("12345678");
		adminTest.setEmail("admin1@orsys.fr");
		administrateurDao.save(adminTest);


	}
}
