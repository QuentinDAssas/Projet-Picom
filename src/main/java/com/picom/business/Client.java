
package com.picom.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class Client extends Utilisateur{
	
	
	private String numeroDeTelephone;

	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Annonce> annonces;
	
}
