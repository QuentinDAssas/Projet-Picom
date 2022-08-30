package com.picom.initialisation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.picom.business.Administrateur;
import com.picom.business.Annonce;
import com.picom.business.Arret;
import com.picom.business.Client;
import com.picom.business.Tarif;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;
import com.picom.dao.AdministrateurDao;
import com.picom.dao.AnnonceDao;
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
	private final AnnonceDao annonceDao;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		addClients();
		addAdministrateurs();
		addZones();
		addArrets();
		addTranchesHoraires();
		addTarifByAdmin();
		addAnnonce();

	}

	// ajout d'un client
	public void addClients() {
		Client clientTest = new Client();
		clientTest.setNom("Orsys");
		clientTest.setPrenom("jury");
		clientTest.setMotDePasse(passwordEncoder.encode("12345678"));
		clientTest.setEmail("client1@orsys.fr");
		clientTest.setNumeroDeTelephone("02 40 35 06 70");
		System.out.println(clientTest);
		clientDao.save(clientTest);

	}

	// ajout d'un administrateur
	public void addAdministrateurs() {
		Administrateur adminTest = new Administrateur();
		adminTest.setNom("l'Eponge");
		adminTest.setPrenom("Bob");
		adminTest.setMotDePasse(passwordEncoder.encode("12345678"));
		adminTest.setEmail("admin1@orsys.fr");
		System.out.println(adminTest);
		administrateurDao.save(adminTest);
	}

	// ajout de zones
	public void addZones() {
		for (int i = 1; i < 6; i++) {
			Zone zone = new Zone();
			zone.setNom("zone " + i);
			System.out.println(zone);
			zoneDao.save(zone);
		}
	}

	// ajout d'arrêts
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

	// ajout de tranches horaires
	public void addTranchesHoraires() {
		for (int i = 6; i < 20; i++) {
			TrancheHoraire trancheHoraire = new TrancheHoraire();
			trancheHoraire.setDebut(i);
			System.out.println(trancheHoraire);
			trancheHoraireDao.save(trancheHoraire);
		}
	}

	// ajout de tarifs
	public void addTarifByAdmin() {
		List<Zone> zones = zoneDao.findAll();
		List<TrancheHoraire> horaire = trancheHoraireDao.findAll();
		Administrateur adminTest = administrateurDao.getById((long) 2);
		int minZone = 1;
		int maxZone = 4;

		int minTrancheHoraire = 1;
		int maxTrancheHoraire = 13;

		int minPrix = 1;
		int maxPrix = 100;

		Random random = new Random();

		int randZone = random.nextInt(maxZone + minZone - 1) + minZone;
		int randTrancheHoraire = random.nextInt(maxTrancheHoraire + minTrancheHoraire - 1) + minTrancheHoraire;
		int randPrix = random.nextInt(maxPrix + minPrix) + minPrix;

		for (int i = 1; i < 4; i++) {
			Tarif testTarif = new Tarif();
			testTarif.setPrixEnEuros(randPrix);
			testTarif.setAdministrateur(adminTest);
			testTarif.setTrancheHoraire(horaire.get(randTrancheHoraire));
			testTarif.setZone(zones.get(randZone));
			tarifDao.save(testTarif);
		}
	}

	// ajout d'annonce
	public void addAnnonce() {
		Annonce annonce = new Annonce();

		Client clientTest = new Client();
		clientTest.setNom("Orsys");
		clientTest.setPrenom("jury");
		clientTest.setMotDePasse(passwordEncoder.encode("12345678"));
		clientTest.setEmail("client2@orsys.fr");
		clientTest.setNumeroDeTelephone("02 40 35 06 70");

		clientDao.save(clientTest);

		List<Zone> zones = zoneDao.findAll();


		List<TrancheHoraire> tranchesHoraires = trancheHoraireDao.findAll();

		annonce.setDateHeureCreation(LocalDateTime.now());
		annonce.setDateHeureDebut(LocalDate.now());
		annonce.setDateHeureFin(LocalDate.now());
		annonce.setContenu("hello world");
		annonce.setNumeroCarte("12345678");
		annonce.setMoisExpiration((byte) 11);
		annonce.setCryptogramme("abc");
		annonce.setMontantRegleEnEuros(23.00);
		annonce.setClient(clientTest);
		annonceDao.save(annonce);
		annonce.setZones(zones);
		annonce.setTranchesHoraires(tranchesHoraires);

		// TODO Trouver une solution pour ne pas faire deux fois appelle à la méthode
		// save()
		annonceDao.save(annonce);

	}

}
