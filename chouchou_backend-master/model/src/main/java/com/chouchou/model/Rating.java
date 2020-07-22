package com.chouchou.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="AVIS")
public class Rating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AVIS_ID")
	private Long id;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "FK_USER_ID", referencedColumnName = "USER_ID")
	private UserManager proprietaire;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_SALON_ID", referencedColumnName = "SALON_ID")
	private Salon salonId;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="SCORE")
	private int score;
	
	
	@Column(name="COMMENTAIRE")
	private String cmtr;


	public Rating() {
		super();
	}


	public Rating(UserManager proprietaire, Date date, int taux, String description) {
		super();
		this.proprietaire = proprietaire;
		this.date = date;
		this.score = score;
		this.cmtr = description;
	}


	public Rating(Long id, UserManager proprietaire, Date date, int taux, String description) {
		super();
		this.id = id;
		this.proprietaire = proprietaire;
		this.date = date;
		this.score = taux;
		this.cmtr = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public UserManager getProprietaire() {
		return proprietaire;
	}


	public void setProprietaire(UserManager proprietaire) {
		this.proprietaire = proprietaire;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getTaux() {
		return score;
	}


	public void setTaux(int taux) {
		this.score = taux;
	}


	public String getDescription() {
		return cmtr;
	}


	public void setDescription(String description) {
		this.cmtr = description;
	}


	@Override
	public String toString() {
		return "Avis [id=" + id + ", proprietaire=" + proprietaire + ", date=" + date + ", taux=" + score
				+ ", description=" + cmtr + "]";
	}


	
	
	

}
