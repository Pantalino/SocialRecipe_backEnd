package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entities.Ricetta;
import com.social.entities.Utente;
import com.social.repos.RicettaDAO;

@Service
public class RicettaServiceImpl implements RicettaService {

	@Autowired
	private RicettaDAO dao;

	@Override
	public List<Ricetta> getAllRicetta() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Ricetta getRicettaById(Long id) {
		return dao.findById(id).orElse(null); // Utilizza findById per recuperare la ricetta
	}

	@Override
	public Ricetta addRicetta(Ricetta ricetta) {
		// TODO Auto-generated method stub
		return dao.save(ricetta);
	}

//	@Override
//	public Ricetta addRicetta(Ricetta ricetta, Long userId) {
//	    Utente utente = utenteService.getUtenteById(userId); // Ottieni l'utente dal service
//	    if (utente != null) {
//	        ricetta.setUtente(utente); // Associa l'utente alla ricetta
//	        return dao.save(ricetta); // Salva la ricetta con l'utente associato
//	    }
//	    return null; // Restituisci null se l'utente non è trovato
//	}
	
	@Override
	public List<Ricetta> getRicettaByUtente(Utente utente) {
		// TODO Auto-generated method stub
		return dao.findByUtente(utente);
	}



//	@Override
//	public Ricetta updateRicetta(Long id, Ricetta updatedRicetta) {
//		Ricetta existingRicetta = dao.findById(id).orElse(null);
//		if (existingRicetta != null) {
//			// Aggiorna i campi necessari dell'oggetto existingRicetta con i valori da
//			// updatedRicetta
//			existingRicetta.setTitolo(updatedRicetta.getTitolo());
//			existingRicetta.setIngredienti(updatedRicetta.getIngredienti());
//			existingRicetta.setIstruzioni(updatedRicetta.getIstruzioni());
//			existingRicetta.setUrlImmagine(updatedRicetta.getUrlImmagine());
//			// ... Altri campi da aggiornare
//
//			return dao.save(existingRicetta); // Salva l'oggetto aggiornato nel database
//		}
//		return null; // Restituisci null se la ricetta non esiste
//	}
//
//	@Override
//	public void deleteRicetta(Long id) {
//		dao.deleteById(id);
//
//	}
	
//	@Override
//	public Ricetta updateRicetta(Long id, Ricetta updatedRicetta) {
//	    Ricetta existingRicetta = dao.findById(id).orElse(null);
//	    if (existingRicetta != null) {
//	        existingRicetta.setTitolo(updatedRicetta.getTitolo());
//	        existingRicetta.setIngredienti(updatedRicetta.getIngredienti());
//	        existingRicetta.setIstruzioni(updatedRicetta.getIstruzioni());
//	        existingRicetta.setUrlImmagine(updatedRicetta.getUrlImmagine());
//	        // ... Altri campi da aggiornare
//
//	        return dao.save(existingRicetta); // Salva l'oggetto aggiornato nel database
//	    }
//	    return null; // Restituisci null se la ricetta non esiste
//	}


}
