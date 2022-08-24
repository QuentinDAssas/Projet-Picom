package com.picom.service;

import javax.validation.Valid;

import com.picom.business.Client;

public interface ClientService {
	
	Client enregistrerClient(@Valid Client client);

}
