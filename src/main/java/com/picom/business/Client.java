package com.picom.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends Utilisateur{
	
	private String numeroDeTelephone;

	@OneToMany(mappedBy="client")
	private List<Annonce> annonces;
}
