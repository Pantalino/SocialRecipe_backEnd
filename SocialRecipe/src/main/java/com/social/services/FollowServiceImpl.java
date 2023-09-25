package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entities.Follow;
import com.social.entities.Utente;
import com.social.repos.FollowDAO;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDAO dao;

    @Override
    public List<Follow> getAllFollower() {
        return dao.findAll();
    }

    @Override
    public List<Follow> getFollowersOfUser(Utente utente) {
        return dao.findByFollowing(utente);
    }

    @Override
    public List<Follow> getFollowingOfUser(Utente utente) {
        return dao.findByFollower(utente);
    }

    @Override
    public Follow addFollow(Utente follower, Utente following) {
        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);
        return dao.save(follow);
    }

    @Override
    public void removeFollow(Utente follower, Utente following) {
        List<Follow> follows = dao.findByFollowerAndFollowing(follower, following);
        if (!follows.isEmpty()) {
            dao.deleteAll(follows);
        }
    }

    @Override
    public boolean followUser(Utente follower, Utente following) {
        // Verifica se la relazione di "follow" già esiste, altrimenti crea una nuova
        List<Follow> follows = dao.findByFollowerAndFollowing(follower, following);
        if (follows.isEmpty()) {
            Follow newFollow = new Follow();
            newFollow.setFollower(follower);
            newFollow.setFollowing(following);
            dao.save(newFollow);
            return true;
        }
        return false;
    }
}
