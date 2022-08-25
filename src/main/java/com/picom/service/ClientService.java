package com.picom.service;

import javax.validation.Valid;

import com.picom.business.Client;
import com.picom.dto.ClientDto;

public interface ClientService {

	Client enregistrerClient(@Valid ClientDto clientDto);

	Client recupererClient(String email, String motDePasse);

	Client recupererUtilisateur(Long id);

}
