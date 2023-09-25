package com.social.services;

import java.util.List;

import com.social.entities.Ricetta;
import com.social.entities.Utente;

public interface RicettaService {

	List<Ricetta> getRicettaByUtente(Utente utente);

	
	List<Ricetta> getAllRicetta();

	Ricetta getRicettaById(Long id);

	Ricetta addRicetta(Ricetta ricetta);
	
	

//	Ricetta updateRicetta(Long id, Ricetta updatedRicetta);
//
//	void deleteRicetta(Long id);

}
