package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.entities.Commento;
import com.social.entities.Ricetta;
import com.social.entities.Utente;
import com.social.services.CommentoService;
import com.social.services.RicettaService;

@RestController
@RequestMapping("api")
public class CommentoREST {
	
	@Autowired
	private CommentoService service;
	
	@Autowired
	private RicettaService ricettaService;
	
	@GetMapping("commenti")
	List<Commento> lista(){	
		return service.getAllCommenti();	
	}
	
	@GetMapping("commenti/{id}")
	Commento commentoById(@PathVariable Long id) {
		return service.getCommentoById(id); //id
	}
	
//	@PostMapping("commenti")
//	Commento addCommento(@RequestBody Commento commento) {
//		return service.addCommento(commento);
//	}
	
	@PostMapping("/commenti")
	public ResponseEntity<Commento> addCommento(@RequestBody Commento commento) {
	    try {
	        Utente utente = commento.getUtente();
	        Ricetta ricetta = commento.getRicetta();

	        // Qui dovresti verificare che gli utenti e le ricette esistano nel database
	        // e ottenere gli oggetti utente e ricetta corrispondenti

	        commento.setUtente(utente);
	        commento.setRicetta(ricetta);

	        Commento nuovoCommento = service.addCommento(commento);
	        return new ResponseEntity<>(nuovoCommento, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
//    @PutMapping("commenti/{id}")
//    Commento updateCommento(@PathVariable Long id, @RequestBody Commento updatedCommento) {
//        return service.updateCommento(id, updatedCommento);
//    }
//
//    @DeleteMapping("commenti/{id}")
//    void deleteCommento(@PathVariable Long id) {
//        service.deleteCommento(id);
//    }
	
}
