package com.picom.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public abstract class Diffusion {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private LocalDateTime dateHeureDiffusion; 
	private Arret arret; 
	private Annonce annonce;

	
	
}
