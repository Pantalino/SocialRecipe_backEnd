package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.entities.Chat;
import com.social.entities.Commento;
import com.social.services.ChatService;

@RestController
@RequestMapping("api")
public class ChatREST {

	@Autowired
	private ChatService chatService;
	
	@GetMapping("chat")
	List<Chat> lista(){	
		return chatService.getAllMessage();	
	}

	@PostMapping("chat")
	public ResponseEntity<Chat> inviaMessaggio(@RequestBody Chat chat) {
		Chat nuovoMessaggio = chatService.inviaMessaggio(chat);
		return ResponseEntity.ok(nuovoMessaggio);
	}

	@GetMapping("chat/{mittenteId}/{destinatarioId}")
	public ResponseEntity<List<Chat>> trovaMessaggiTraUtenti(@PathVariable Long mittenteId,
			@PathVariable Long destinatarioId) {
		List<Chat> messaggi = chatService.trovaMessaggiTraUtenti(mittenteId, destinatarioId);
		return ResponseEntity.ok(messaggi);
	}
}
