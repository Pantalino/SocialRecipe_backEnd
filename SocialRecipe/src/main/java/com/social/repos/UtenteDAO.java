package com.social.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Utente;

public interface UtenteDAO extends JpaRepository<Utente, Long> {

	Utente findByEmailAndPassword(String email, String password);

//	Utente findByUsername(String username);
	
	Utente findByEmail(String email);
	
	Utente findByNomeAndCognome(String nome, String cognome);
	
	Utente findByNome(String nome);
	
	Utente findByCognome(String cognome);
}
