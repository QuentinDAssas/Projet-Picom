package com.picom.business;

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
public class Arret {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private String nom; 
	private double longitude; 
	private double latitude; 
	private Zone zone; 
	

}
