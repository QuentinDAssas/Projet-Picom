package com.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarif {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private double prixEnEuros;
	
	@ManyToOne
	Administrateur administrateur;
	
	@OneToOne
	private Zone zone;
	
	@OneToOne
	private TrancheHoraire trancheHoraire;
	
}
