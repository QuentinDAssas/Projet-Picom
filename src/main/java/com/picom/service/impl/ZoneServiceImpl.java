package com.picom.service.impl;

import org.springframework.stereotype.Service;

import com.picom.dao.ZoneDao;
import com.picom.service.ZoneService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZoneServiceImpl implements ZoneService{

	private ZoneDao zoneDao; 
}
