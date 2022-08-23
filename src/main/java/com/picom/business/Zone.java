package com.picom.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
public class Zone {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private String nom; 
	
	@OneToMany
	(mappedBy="zone")
	private List<Arret>arrets;
	
	@ManyToMany
	(mappedBy="zones")
	private List<Annonce>annonces;
	
}
