package com.picom.service.impl;

import org.springframework.stereotype.Service;

import com.picom.dao.ArretDao;
import com.picom.service.ArretService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArretServiceImpl implements ArretService{
	
	private ArretDao arretDao; 
}
