package com.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picom.business.Diffusion;

public interface DiffusionDao extends JpaRepository<Diffusion, Long> {

}
