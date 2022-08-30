package com.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picom.business.Tarif;
import com.picom.dto.TarifDto;

public interface TarifDao extends JpaRepository<Tarif, Long>{

	@Query("Select prixEnEuros FROM Tarif WHERE tranche_horaire_id=?1 AND zone_id=?2")
	double findPrixEnEurosByidTrancheHoraireAndIdZone(Long idTrancheHoraire, Long idZone );
	

}
