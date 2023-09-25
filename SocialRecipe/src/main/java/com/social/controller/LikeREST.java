package com.social.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.entities.Like;
import com.social.entities.Ricetta;
import com.social.entities.Utente;
import com.social.services.LikeService;
import com.social.services.RicettaService;
import com.social.services.UtenteService;

@RestController
@RequestMapping("api")
public class LikeREST {

    @Autowired
    private LikeService service;
    
    @Autowired
    private UtenteService utenteService;
    
    @Autowired
    private RicettaService ricettaService;
    


    @GetMapping("likes")
    List<Like> lista() {
        return service.getAllLikes();
    }
    
    @GetMapping("likes/{ricettaId}")
    List<Like> getLikesByRicetta(@PathVariable Long ricettaId) {
        Ricetta ricetta = ricettaService.getRicettaById(ricettaId);
        if (ricetta != null) {
            return service.getLikesByRicetta(ricetta);
        }
        return new ArrayList<>();
    }


    @PostMapping("likes")
    Like addLike(@RequestBody Map<String, Long> requestBody) {
        Long utenteId = requestBody.get("utenteId");
        Long ricettaId = requestBody.get("ricettaId");

        Utente utente = utenteService.getUtenteById(utenteId); // Metodo per recuperare l'utente dal servizio UtenteService
        Ricetta ricetta = ricettaService.getRicettaById(ricettaId); // Metodo per recuperare la ricetta dal servizio RicettaService

        if (utente == null || ricetta == null) {
            // Gestisci il caso in cui l'utente o la ricetta non esistano
            throw new RuntimeException("Utente o ricetta non trovati");
        }

        return service.addLike(utente, ricetta);
    }
    
    @GetMapping("likes/{ricettaId}/utente/{utenteId}")
    List<Like> getLikesByRicettaAndUtente(@PathVariable Long ricettaId, @PathVariable Long utenteId) {
        Ricetta ricetta = ricettaService.getRicettaById(ricettaId);
        Utente utente = utenteService.getUtenteById(utenteId);
        
        if (ricetta != null && utente != null) {
            return service.getLikesByUtenteAndRicetta(utente, ricetta);
        }
        
        return new ArrayList<>();
    }


    
    
    @DeleteMapping("likes/{ricettaId}")
    public ResponseEntity<?> removeLike(@RequestBody Map<String, Long> requestBody) {
        Long utenteId = requestBody.get("utenteId");
        Long ricettaId = requestBody.get("ricettaId");

        Utente utente = utenteService.getUtenteById(utenteId);
        Ricetta ricetta = ricettaService.getRicettaById(ricettaId);

        if (utente == null || ricetta == null) {
            return ResponseEntity.badRequest().body("Utente o ricetta non trovati");
        }

        if (service.isLikedByUser(utente, ricetta)) {
            service.removeLike(utente, ricetta);
            return ResponseEntity.ok().body("Like rimosso con successo.");
        } else {
            return ResponseEntity.badRequest().body("L'utente non aveva messo Mi Piace a questa ricetta.");
        }
    }


}
