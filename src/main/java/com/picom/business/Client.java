package com.picom.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Utilisateur{
	
	private String numeroDeTelephone;

	@OneToMany(mappedBy="client")
	private List<Annonce> annonces;
}
