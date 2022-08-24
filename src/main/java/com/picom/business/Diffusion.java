package com.picom.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
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
public class Diffusion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	private LocalDateTime dateHeureDiffusion; 
	@ManyToOne
	private Arret arret; 
	@ManyToOne
	private Annonce annonce;

	
	
}
