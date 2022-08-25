package com.picom.service.impl;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.picom.business.Client;
import com.picom.dao.ClientDao;
import com.picom.dto.ClientDto;
import com.picom.service.ClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
	
	private ClientDao clientDao;



	@Override
	public Client recupererClient(String email, String motDePasse) {
		return clientDao.findLastByEmailAndMotDePasse(email, motDePasse);
	}


	@Override
	public Client enregistrerClient(@Valid ClientDto clientDto) {
		Client client = new Client();
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		client.setEmail(clientDto.getEmail());
        client.setMotDePasse(clientDto.getMotDePasse());
        client.setNumeroDeTelephone(clientDto.getNumeroDeTelephone());
        clientDao.save(client);
        return client;
	}


	@Override
	public Client recupererUtilisateur(Long id) {
		return clientDao.findById(id).orElse(null);
	}




}
