package com.social.services;

import java.util.List;

import com.social.entities.Commento;
import com.social.entities.Ricetta;

public interface CommentoService {

	List<Commento> getCommentoByRicetta(Ricetta ricetta);

	List<Commento> getAllCommenti();

	Commento getCommentoById(Long id);

	Commento addCommento(Commento commento);

//	Commento updateCommento(Long id, Commento updatedCommento);
//
//	void deleteCommento(Long id);

}
