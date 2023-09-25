package com.social.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Like;
import com.social.entities.Ricetta;
import com.social.entities.Utente;

public interface LikeDAO extends JpaRepository<Like, Long> {

	List<Like> findByUtente(Utente utente);

	List<Like> findByRicetta(Ricetta ricetta);
	
	List<Like> findByUtenteAndRicetta(Utente utente, Ricetta ricetta);
}
