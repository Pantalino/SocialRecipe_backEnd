package com.social.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.social.entities.Commento;
import com.social.services.CommentoService;

@Controller
@RequestMapping("/commenti")
public class CommentoMVC {

    @Autowired
    private CommentoService service;

    @GetMapping("/form")
    public String showForm() {
        return "commento-form"; // Nome della vista HTML per il form
    }

    @PostMapping("/aggiungi")
    public String addCommento(Commento commento, RedirectAttributes redirectAttrs) {
        service.addCommento(commento);
        redirectAttrs.addFlashAttribute("successMessage", "Commento aggiunto con successo");
        return "redirect:/commenti/form";
    }

    @GetMapping("/elenco")
    public String showElenco(Model model) {
        model.addAttribute("commenti", service.getAllCommenti());
        return "commenti-elenco"; // Nome della vista HTML per l'elenco commenti
    }

}
