package com.social.services;

import java.util.List;

import com.social.entities.Chat;

public interface ChatService {
	
	Chat inviaMessaggio(Chat chat);

	List<Chat> trovaMessaggiTraUtenti(Long mittenteId, Long destinatarioId);
	// Altri metodi di servizio se necessari
	
	List<Chat> getAllMessage();
}
