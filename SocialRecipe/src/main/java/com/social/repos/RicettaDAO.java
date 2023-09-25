package com.social.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Ricetta;
import com.social.entities.Utente;

public interface RicettaDAO extends JpaRepository<Ricetta, Long> {
	List<Ricetta> findByUtente(Utente utente);

	List<Ricetta> findByIngredientiContainingIgnoreCase(String ingredienti);



//	List<Ricetta> findAllByOrderByCreatedAtDesc();
}
