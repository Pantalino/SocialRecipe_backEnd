package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entities.Utente;
import com.social.repos.UtenteDAO;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDAO dao;

	@Override
	public List<Utente> getAllUtenti() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Utente getUtenteById(Long id) {
		return dao.findById(id).orElse(null); // Utilizza findById per recuperare l'utente
	}

	@Override
	public Utente addUtente(Utente utente) {
		// TODO Auto-generated method stub
		return dao.save(utente);
	}

	@Override
	public Utente findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return dao.findByEmailAndPassword(email, password);
	}

//	@Override
//	public Utente findByUsername(String username) {
//		// TODO Auto-generated method stub
//		return dao.findByUsername(username);
//	}

	@Override
	public Utente findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		Utente utente = dao.findByEmailAndPassword(email, password);
		return utente != null;
	}

	@Override
	public Utente findByNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNome(nome);
	}

	@Override
	public Utente findByCognome(String cognome) {
		// TODO Auto-generated method stub
		return dao.findByCognome(cognome);
	}
	


	@Override
	public void deleteUtente(Long id) {
		dao.deleteById(id);		
	}

	@Override
	public Utente findByNomeAndCognome(String nome, String cognome) {
		// TODO Auto-generated method stub
		return dao.findByNomeAndCognome(nome, cognome);
	}

//	@Override
//	public Utente updateUtente(Long id, Utente updatedUtente) {
//		Utente existingUtente = dao.findById(id).orElse(null);
//		if (existingUtente != null) {
//			// Aggiorna i campi necessari dell'oggetto existingUtente con i valori da
//			// updatedUtente
//			existingUtente.setUsername(updatedUtente.getUsername());
//			existingUtente.setPassword(updatedUtente.getPassword());
//			existingUtente.setEmail(updatedUtente.getEmail());
//			// ... Altri campi da aggiornare
//
//			return dao.save(existingUtente); // Salva l'oggetto aggiornato nel database
//		}
//		return null; // Restituisci null se l'utente non esiste
//	}
//
//	@Override
//	public void deleteUtente(Long id) {
//		dao.deleteById(id);
//
//	}

}
