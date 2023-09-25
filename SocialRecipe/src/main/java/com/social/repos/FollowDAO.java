package com.social.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Follow;
import com.social.entities.Utente;

public interface FollowDAO extends JpaRepository<Follow, Long>{

	List<Follow> findByFollower(Utente follower);

	List<Follow> findByFollowerAndFollowing(Utente follower, Utente following);

	List<Follow> findByFollowing(Utente utente);
}
