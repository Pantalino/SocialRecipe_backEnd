package com.social.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Chat;
import com.social.entities.Utente;

public interface ChatDAO extends JpaRepository<Chat, Long>{
	


	List<Chat> findByMittenteAndDestinatario(Utente mittente, Utente destinatario);


}
