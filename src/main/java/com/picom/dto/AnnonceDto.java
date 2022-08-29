package com.picom.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnonceDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDateTime dateHeureCreation; 
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDateTime dateHeureDebut; 
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDateTime dateHeureFin; 
	private String contenu; 
	private String numeroCarte; 
	private int anneeExpiration; 
	private byte moisExpiration; 
	private String cryptogramme; 
	Long idClient;
	List<Long> idZoneAnnonce;
	List<Long> idTrancheHoraireAnnonce;
	private double montantRegleEnEuros; 
}
