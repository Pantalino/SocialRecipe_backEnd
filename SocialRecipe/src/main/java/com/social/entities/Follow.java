package com.social.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="follows")
public class Follow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="id_follow")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="follower_id")
	private Utente follower;
	
	@ManyToOne
	@JoinColumn(name="following_id")
	private Utente following;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utente getFollower() {
		return follower;
	}

	public void setFollower(Utente follower) {
		this.follower = follower;
	}

	public Utente getFollowing() {
		return following;
	}

	public void setFollowing(Utente following) {
		this.following = following;
	}
	
	
}
