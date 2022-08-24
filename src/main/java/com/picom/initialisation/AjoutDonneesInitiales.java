package com.picom.initialisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.picom.business.Administrateur;
import com.picom.business.Client;
import com.picom.business.Zone;
import com.picom.dao.AdministrateurDao;
import com.picom.dao.ClientDao;
import com.picom.dao.ZoneDao;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final AdministrateurDao administrateurDao;
	private final ClientDao clientDao;
	private final ZoneDao zoneDao;

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

		Zone zone1 = new Zone();
		zone1.setNom("Centre");
		zoneDao.save(zone1);
		Zone zone2 = new Zone();
		zone2.setNom("Nord");
		zoneDao.save(zone2);
		Zone zone3 = new Zone();
		zone3.setNom("Est");
		zoneDao.save(zone3);
		Zone zone4 = new Zone();
		zone4.setNom("Ouest");
		zoneDao.save(zone4);
		Zone zone5 = new Zone();
		zone1.setNom("Sud");
		zoneDao.save(zone5);
	}
}
