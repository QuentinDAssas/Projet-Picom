package com.picom.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Annonce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	
	@ManyToOne
	private Client client; 
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Zone>zones; 
	
	@ManyToMany
	private List<TrancheHoraire>tranchesHoraires;
	

	
	public Annonce() {
		dateHeureCreation = LocalDateTime.now();
	}
	
}	
