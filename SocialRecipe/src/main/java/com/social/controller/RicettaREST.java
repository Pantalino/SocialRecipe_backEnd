package com.social.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.entities.Commento;
import com.social.entities.Ricetta;
import com.social.entities.Utente;
import com.social.services.CommentoService;
import com.social.services.RicettaService;
import com.social.services.UtenteService;

@RestController
@RequestMapping("api")
public class RicettaREST {

	@Autowired
	private RicettaService service;

	@Autowired
	private CommentoService commentoService;
	
	private UtenteService utenteService;

	@GetMapping("ricette")
	List<Ricetta> lista() {
		return service.getAllRicetta();
	}

//	@GetMapping("ricette/{id}")
//	Ricetta getRicettaById(@PathVariable Long id) {
//		return service.getRicettaById(id); //id
//	}

	@PostMapping("ricette")
	Ricetta addRicetta(@RequestBody Ricetta ricetta) {
		return service.addRicetta(ricetta);
	}

//	@PostMapping("ricette")
//	public ResponseEntity<?> addRicetta(@RequestBody Ricetta ricetta, @RequestParam Long userId) {
//	    try {
//	        // Effettua la validazione dei dati
//	        if (ricetta.getTitolo() == null || ricetta.getTitolo().isEmpty()) {
//	            return ResponseEntity.badRequest().body("Il titolo della ricetta è obbligatorio.");
//	        }
//
//	        // Ottieni l'utente associato alla ricetta tramite l'ID
//	        Utente utente = utenteService.getUtenteById(userId);
//	        if (utente == null) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato.");
//	        }
//
//	        // Associa l'utente alla ricetta
//	        ricetta.setUtente(utente);
//
//	        // Effettua la creazione e il salvataggio della ricetta
//	        Ricetta nuovaRicetta = service.addRicetta(ricetta);
//
//	        // Restituisci la risposta di successo con la nuova ricetta creata
//	        return ResponseEntity.status(HttpStatus.CREATED).body(nuovaRicetta);
//	    } catch (Exception e) {
//	        // Gestisci eventuali errori
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                .body("Errore durante la creazione della ricetta.");
//	    }
//	}



	// cose nuove
	@GetMapping("/ricette/{id}")
	public ResponseEntity<Ricetta> getRicettaById(@PathVariable Long id) {
		Ricetta ricetta = service.getRicettaById(id);
		if (ricetta != null) {
			return ResponseEntity.ok(ricetta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/ricette/{id}/commenti")
	public ResponseEntity<List<Commento>> getCommentiByRicetta(@PathVariable Long id) {
		Ricetta ricetta = service.getRicettaById(id);
		if (ricetta != null) {
			List<Commento> commenti = commentoService.getCommentoByRicetta(ricetta);
			return ResponseEntity.ok(commenti);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
