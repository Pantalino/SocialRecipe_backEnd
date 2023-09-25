package com.social.services;

import java.util.List;


import com.social.entities.Follow;
import com.social.entities.Utente;

public interface FollowService {
	
    List<Follow> getAllFollower();

    List<Follow> getFollowersOfUser(Utente utente);

    List<Follow> getFollowingOfUser(Utente utente);

    Follow addFollow(Utente follower, Utente following);

    void removeFollow(Utente follower, Utente following);
    
    //cose nuove
    
    boolean followUser(Utente follower, Utente following);
}
