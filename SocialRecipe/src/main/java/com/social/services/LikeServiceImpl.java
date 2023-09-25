package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.social.entities.Like;
import com.social.entities.Ricetta;
import com.social.entities.Utente;
import com.social.repos.LikeDAO;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeDAO dao;

//	@Autowired
//	private SimpMessagingTemplate messagingTemplate;

	@Override
	public List<Like> getAllLikes() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Like> getLikesByUtente(Utente utente) {
		return dao.findByUtente(utente);
	}

	@Override
	public List<Like> getLikesByRicetta(Ricetta ricetta) {
		return dao.findByRicetta(ricetta);
	}

	@Override
	public Like addLike(Utente utente, Ricetta ricetta) {
		Like like = new Like();
		like.setUtente(utente);
		like.setRicetta(ricetta);
		return dao.save(like);
	}

    @Override
    public void removeLike(Utente utente, Ricetta ricetta) {
        List<Like> likes = dao.findByUtenteAndRicetta(utente, ricetta);
        dao.deleteAll(likes);
    }

    @Override
    public boolean isLikedByUser(Utente utente, Ricetta ricetta) {
        List<Like> likes = dao.findByUtenteAndRicetta(utente, ricetta);
        return !likes.isEmpty();
    }

	@Override
	public List<Like> getLikesByUtenteAndRicetta(Utente utente, Ricetta ricetta) {
		// TODO Auto-generated method stub
		return dao.findByUtenteAndRicetta(utente, ricetta);
	}


	// SSE
//	@Override
//	public void sendLikeUpdate(Long recipeId, int likeCount) {
//		 SseEmitter emitter = new SseEmitter(); // Creazione del SseEmitter
//
//		    // Creazione dell'oggetto di aggiornamento
//		    
//		    likeUpdate.setRecipeId(recipeId);
//		    likeUpdate.setLikeCount(likeCount);
//
//		    try {
//		        emitter.send(likeUpdate); // Invio dell'aggiornamento attraverso l'emitter
//		    } catch (Exception e) {
//		        // Gestione delle eccezioni
//		    } finally {
//		        emitter.complete(); // Completamento dell'emitter dopo l'invio
//		    }		
//	}

//webSocket
//	@Override
//	public void sendLikeUpdate(Long recipeId, int likeCount) {
//		Map<String, Object> update = new HashMap<>();
//		update.put("recipeId", recipeId);
//		update.put("likeCount", likeCount);
//		messagingTemplate.convertAndSend("/topic/likeUpdate", update);
//	}

}
