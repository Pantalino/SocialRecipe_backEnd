package com.social.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.entities.Follow;
import com.social.entities.Utente;
import com.social.services.FollowService;
import com.social.services.UtenteService;

@RestController
@RequestMapping("api")
public class FollowREST {

    @Autowired
    private FollowService service;
    
    @Autowired
    private UtenteService utenteService;
    

    @PostMapping("follows")
    public Follow addFollow(@RequestBody Follow follow) {
        Utente follower = follow.getFollower();
        Utente following = follow.getFollowing();
        return service.addFollow(follower, following);
    }
    
    @PostMapping("follows/{followerId}/follows/{followingId}")
    public ResponseEntity<?> followUser(@PathVariable Long followerId, @PathVariable Long followingId) {
        // Ottenere gli oggetti Utente follower e following dal servizio o repository
        Utente follower = utenteService.getUtenteById(followerId);
        Utente following = utenteService.getUtenteById(followingId);

        // Effettuare l'azione di "follow" e restituire una risposta appropriata
        if (service.followUser(follower, following)) {
            return ResponseEntity.ok().body("Follow effettuato con successo.");
        } else {
            return ResponseEntity.badRequest().body("Il follow esiste già.");
        }
    }
    
    @DeleteMapping("follow/{followerId}/unfollow/{followingId}")
    public ResponseEntity<?> unfollowUser(@PathVariable Long followerId, @PathVariable Long followingId) {
        Utente follower = utenteService.getUtenteById(followerId);
        Utente following = utenteService.getUtenteById(followingId);

        service.removeFollow(follower, following);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Follow rimosso con successo.");
        return ResponseEntity.ok().body(responseMap);
    }

    
    @GetMapping("follows")
    List<Follow> lista() {
        return service.getAllFollower();
    }

    @GetMapping("follows/{followerId}/followers")
    List<Follow> followersOfUser(@PathVariable Long followerId) {
        Utente follower = new Utente();
        follower.setId(followerId);
        return service.getFollowersOfUser(follower);
    }

    @GetMapping("follows/{followingId}/following")
    List<Follow> followingOfUser(@PathVariable Long followingId) {
        Utente following = new Utente();
        following.setId(followingId);
        return service.getFollowingOfUser(following);
    }

 
}
