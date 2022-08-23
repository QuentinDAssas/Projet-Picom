package com.picom.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Annonce {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private LocalDateTime dateHeureCreation; 
	private LocalDateTime dateHeureDebut; 
	private LocalDateTime dateHeureFin; 
	private String contenu; 
	private String numeroCarte; 
	private int anneeExpiration; 
	private byte moisExpiration; 
	private String cryptogramme; 
	private double montantRegleEnEuros; 
	
	@ManyToMany
	private List<Zone>lstZones; 
	
	@ManyToMany
	private List<TrancheHoraire>lstTrancheHoraire; 
	
}