package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entities.Commento;
import com.social.entities.Ricetta;
import com.social.repos.CommentoDAO;

@Service
public class CommentoServiceImpl implements CommentoService{

	@Autowired
	private CommentoDAO dao;
	
	@Override
	public List<Commento> getAllCommenti() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Commento getCommentoById(Long id) {
	    return dao.findById(id).orElse(null); // Utilizza findById per recuperare il commento
	}


	@Override
	public Commento addCommento(Commento commento) {
		// TODO Auto-generated method stub
		return dao.save(commento);
	}

	@Override
	public List<Commento> getCommentoByRicetta(Ricetta ricetta) {
		// TODO Auto-generated method stub
		return dao.findByRicetta(ricetta);
	}

//	@Override
//	public Commento updateCommento(Long id, Commento updatedCommento) {
//		 Commento existingCommento = dao.findById(id).orElse(null);
//	        if (existingCommento != null) {
//	            // Aggiorna i campi necessari dell'oggetto existingCommento con i valori da updatedCommento
//	            existingCommento.setContenuto(updatedCommento.getContenuto());
//	            // ... Altri campi da aggiornare
//
//	            return dao.save(existingCommento); // Salva l'oggetto aggiornato nel database
//	        }
//	        return null; // Restituisci null se il commento non esiste
//	}
//
//	@Override
//	public void deleteCommento(Long id) {
//        dao.deleteById(id);
//		
//	}

}
