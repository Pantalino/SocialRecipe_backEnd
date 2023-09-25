package com.social.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ricette")
public class Ricetta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titolo;
	
	@Column(name = "ingredienti", length = 2000)
	private String ingredienti;
	
	@Column(name = "istruzioni", length = 2000)
	private String istruzioni;
	
	@Column(name = "url_immagine", length = 2000)
	private String urlImmagine;

	@OneToMany(mappedBy = "ricetta")
	private List<Commento> commenti;

	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@CreationTimestamp
	@Column(name = "data")
	private LocalDateTime data;
	
	
	//
    @Lob
//    private byte[] immagine;
//
//    public byte[] getImmagine() {
//        return immagine;
//    }
//
//    public void setImmagine(byte[] immagine) {
//        this.immagine = immagine;
//    }
    //

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public String getIstruzioni() {
		return istruzioni;
	}

	public void setIstruzioni(String istruzioni) {
		this.istruzioni = istruzioni;
	}

	public String getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
