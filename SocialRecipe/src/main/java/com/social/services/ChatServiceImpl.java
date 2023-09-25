package com.social.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entities.Chat;
import com.social.entities.Utente;
import com.social.repos.ChatDAO;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatDAO dao;
	
	@Autowired
	private UtenteService service;


    @Override
    public Chat inviaMessaggio(Chat chat) {
        // Implementa la logica per inviare il messaggio, ad esempio, salvando il messaggio nel repository.
        return dao.save(chat);
    }

    @Override
    public List<Chat> trovaMessaggiTraUtenti(Long mittenteId, Long destinatarioId) {
        Utente mittente = service.getUtenteById(mittenteId); // Assumendo che tu abbia un servizio utente (utenteService) per ottenere gli oggetti Utente
        Utente destinatario = service.getUtenteById(destinatarioId);
        if (mittente != null && destinatario != null) {
            return dao.findByMittenteAndDestinatario(mittente, destinatario);
        }
        return new ArrayList<>(); // Gli utenti non sono stati trovati, ritorna una lista vuota
    }

	@Override
	public List<Chat> getAllMessage() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
