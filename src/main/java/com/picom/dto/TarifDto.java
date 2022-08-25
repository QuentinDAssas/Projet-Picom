package com.picom.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.picom.business.Administrateur;
import com.picom.business.TrancheHoraire;
import com.picom.business.Zone;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TarifDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private double prixEnEuros;
	
	@ManyToOne
	Administrateur administrateur;
	
	@ManyToOne
	@NotNull(message="Merci de préciser la zone")
	private Zone zone;
	
	@ManyToOne
	@NotNull(message="Merci de préciser la tranche horaire")
	private TrancheHoraire trancheHoraire;
}
