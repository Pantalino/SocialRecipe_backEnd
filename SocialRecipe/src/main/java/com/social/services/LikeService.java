package com.social.services;

import java.util.List;

import com.social.entities.Like;
import com.social.entities.Ricetta;
import com.social.entities.Utente;

public interface LikeService {
 
	List<Like> getAllLikes();
	
    List<Like> getLikesByUtente(Utente utente);

    List<Like> getLikesByRicetta(Ricetta ricetta);

    List<Like> getLikesByUtenteAndRicetta(Utente utente,Ricetta ricetta );


    Like addLike(Utente utente, Ricetta ricetta);
    
    void removeLike(Utente utente, Ricetta ricetta);

    boolean isLikedByUser(Utente utente, Ricetta ricetta);
    
    
    
    //non so se è giusto
//    void sendLikeUpdate(Long recipeId, int likeCount);

}
