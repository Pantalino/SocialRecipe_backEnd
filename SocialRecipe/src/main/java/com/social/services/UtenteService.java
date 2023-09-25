package com.social.services;

import java.util.List;

import com.social.entities.Utente;

public interface UtenteService {

	List<Utente> getAllUtenti();

	Utente getUtenteById(Long id);

	Utente addUtente(Utente utente);

	Utente findByEmailAndPassword(String email, String password);
	
	Utente findByEmail(String email);
	
	Utente findByNomeAndCognome(String nome, String cognome);
	
	Utente findByNome(String nome);
	
	Utente findByCognome(String cognome);
	
	boolean verifyLogin(String email, String password);

	void deleteUtente(Long id);
	

//	Utente updateUtente(Long id, Utente updatedUtente);
//
}
