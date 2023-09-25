package com.social.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.social.entities.Commento;
import com.social.entities.Ricetta;

public interface CommentoDAO extends JpaRepository<Commento, Long>{
	List<Commento> findByRicetta(Ricetta ricetta);
	
}
