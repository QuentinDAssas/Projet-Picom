package com.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picom.business.Client;

public interface ClientDao extends JpaRepository<Client, Long>{

}
