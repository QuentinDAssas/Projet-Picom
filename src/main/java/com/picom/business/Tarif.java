package com.picom.business;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Zone zone;
	

	@ManyToOne(fetch=FetchType.EAGER)
	private TrancheHoraire trancheHoraire;
		
}
