package com.picom.business;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

	public Tarif(Long id, double prixEnEuros, @NotNull(message = "Merci de préciser la Zone") Zone zone,
			@NotNull(message = "Merci de préciser la tranche horaire") TrancheHoraire trancheHoraire) {
		super();
		this.id = id;
		this.prixEnEuros = prixEnEuros;
		this.zone = zone;
		this.trancheHoraire = trancheHoraire;
	}
	
	
}
