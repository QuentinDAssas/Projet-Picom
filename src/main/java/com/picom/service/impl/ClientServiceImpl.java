package com.picom.service.impl;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private final PasswordEncoder passwordEncoder;


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
        client.setMotDePasse(passwordEncoder.encode(clientDto.getMotDePasse()));
        client.setNumeroDeTelephone(clientDto.getNumeroDeTelephone());
        clientDao.save(client);
        return client;
	}


	@Override
	public Client recupererClient(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public Client recupererClient(Client client) {
		return clientDao.findById(client.getId()).orElse(null);
	}


}
