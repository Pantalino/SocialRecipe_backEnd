package com.social.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.social.entities.Ricetta;
import com.social.services.RicettaService;

@Controller
@RequestMapping("/ricette")
public class RicettaMVC {

    @Autowired
    private RicettaService service;

    @GetMapping("/form")
    public String showForm() {
        return "ricetta-form"; // Nome della vista HTML per il form
    }

    @PostMapping("/aggiungi")
    public String addRicetta(Ricetta ricetta, RedirectAttributes redirectAttrs) {
        service.addRicetta(ricetta);
        redirectAttrs.addFlashAttribute("successMessage", "Ricetta aggiunta con successo");
        return "redirect:/ricette/form";
    }

    @GetMapping("/elenco")
    public String showElenco(Model model) {
        model.addAttribute("ricette", service.getAllRicetta());
        return "ricette-elenco"; // Nome della vista HTML per l'elenco ricette
    }

}

