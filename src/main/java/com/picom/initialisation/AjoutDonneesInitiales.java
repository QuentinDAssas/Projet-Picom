package com.picom.initialisation;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.picom.business.Administrateur;
import com.picom.business.Arret;
import com.picom.business.Client;
import com.picom.business.Tarif;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dao.AdministrateurDao;
import com.picom.dao.ArretDao;
import com.picom.dao.ClientDao;
import com.picom.dao.TarifDao;
import com.picom.dao.TrancheHoraireDao;
import com.picom.dao.ZoneDao;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final AdministrateurDao administrateurDao;
	private final ClientDao clientDao;
	private final ZoneDao zoneDao;
	private final ArretDao arretDao;
	private final TrancheHoraireDao trancheHoraireDao;
	private final TarifDao tarifDao;

	@Override
	public void run(String... args) throws Exception {

		addClients();
		addAdministrateurs();
		addZones();
		addArrets();
		addTranchesHoraires();
		addTarifByAdmin();


	}

	public void addClients() {
		Client clientTest = new Client();
		clientTest.setNom("Orsys");
		clientTest.setPrenom("jury");
		clientTest.setMotDePasse("12345678");
		clientTest.setEmail("client1@orsys.fr");
		clientTest.setNumeroDeTelephone("02 40 35 06 70");
		System.out.println(clientTest);
		clientDao.save(clientTest);

	}

	public void addAdministrateurs() {
		Administrateur adminTest = new Administrateur();
		adminTest.setNom("l'Eponge");
		adminTest.setPrenom("Bob");
		adminTest.setMotDePasse("12345678");
		adminTest.setEmail("admin1@orsys.fr");
		System.out.println(adminTest);
		administrateurDao.save(adminTest);
	}

	public void addZones() {
		for (int i = 1; i < 6; i++) {
			Zone zone = new Zone();
			zone.setNom("zone " + i);
			System.out.println(zone);
			zoneDao.save(zone);
		}
	}
	
	public void addArrets() {
		List<Zone> zones = zoneDao.findAll();
		for (Zone zone : zones)

		{
			for (int i = 1; i < 5; i++) {
				Arret arret = new Arret();
				Random rand = new Random();

				double latitude = rand.nextDouble(1, 10);
				double longitude = rand.nextDouble(1, 10);
							
				arret.setNom("arret" + i);
				arret.setLatitude(latitude);
				arret.setLongitude(longitude);
				arret.setZone(zone);
				System.out.println(arret);
				arretDao.save(arret);
			}

		}
	}

	public void addTranchesHoraires() {
		for (int i = 6; i < 21; i++) {
			TrancheHoraire trancheHoraire = new TrancheHoraire();
			trancheHoraire.setDebut(i);
			System.out.println(trancheHoraire);
			trancheHoraireDao.save(trancheHoraire);
		}
	}
	
	public void addTarifByAdmin() {
		List<Zone> zones = zoneDao.findAll();
		List<TrancheHoraire> horaire = trancheHoraireDao.findAll();
		Administrateur adminTest = administrateurDao.getById((long) 2);
		Tarif testTarif = new Tarif();
		
		testTarif.setPrixEnEuros(12);
		testTarif.setAdministrateur(adminTest);
		testTarif.setTrancheHoraire(horaire.get(2));
		testTarif.setZone(zones.get(1));
		tarifDao.save(testTarif);
	}
	
	
	
}
