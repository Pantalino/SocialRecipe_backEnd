package com.social.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.social.entities.Utente;
import com.social.services.UtenteService;

@Controller
@RequestMapping("/utenti") // Mappare le richieste relative agli utenti
public class UtenteMVC {

    @Autowired
    private UtenteService service;

    @GetMapping("/form")
    public String showForm() {
        return "utente-form"; // Nome della vista HTML per il form
    }

    @PostMapping("/aggiungi")
    public String addUtente(Utente utente, RedirectAttributes redirectAttrs) {
        service.addUtente(utente);
        redirectAttrs.addFlashAttribute("successMessage", "Utente aggiunto con successo");
        return "redirect:/utenti/form";
    }

    @GetMapping("/elenco")
    public String showElenco(Model model) {
        model.addAttribute("utenti", service.getAllUtenti());
        return "utenti-elenco"; // Nome della vista HTML per l'elenco utenti
    }

}


