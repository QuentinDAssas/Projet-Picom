package com.picom.service.impl;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.picom.business.Client;
import com.picom.dao.ClientDao;
import com.picom.service.ClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
	
	private ClientDao clientDao;


}
