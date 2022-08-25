package com.picom.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {

	@NotBlank(message="{client.nom.manquant}")
	String nom;
	
	@NotBlank(message="{client.prenom.manquant}")
	String prenom;
	
	@Email(message="Merci de préciser une adresse email au bon format")
	@NotBlank(message="Merci de préciser une adresse email")
	@Pattern(regexp="^([A-Za-z0-9-])+(.[A-Za-z0-9-]+)*@orsys.fr$", message="Votre adresse doit faire partie du nom de domaine orsys.fr")
	String email;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min=8, message="{client.mot-de-passe.invalide}")
	String motDePasse;
	
	@Size(min=10, max= 10, message="{client.numero-de-telephone.invalide}")
	@NotBlank(message="{client.numeroDeTelephone.manquant}")
	String numeroDeTelephone;

}