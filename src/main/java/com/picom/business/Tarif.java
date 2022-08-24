package com.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	public Tarif(double prixEnEuros, Zone zone, TrancheHoraire trancheHoraire) {
		this.prixEnEuros=prixEnEuros;
		this.zone=zone;
		this.trancheHoraire=trancheHoraire;
	}
	
}
