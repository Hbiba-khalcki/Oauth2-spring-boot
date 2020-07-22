package com.chouchou.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALON")
public class Journee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SALON_ID")
	private Long id;

	@Column(name = "NOM_JOURNEE")
	private String nom;

	@Column(name = "HEURE_OUVERT")
	private int h_ouvert;
	
	@Column(name = "HEURE_FERME")
	private int h_ferme;
	
	@Column(name = "DISPONIBLE")
	private boolean disponible;

	
	
	
	


	public Journee() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getH_ouvert() {
		return h_ouvert;
	}

	public void setH_ouvert(int h_ouvert) {
		this.h_ouvert = h_ouvert;
	}



	public int getH_ferme() {
		return h_ferme;
	}

	public void setH_ferme(int h_ferme) {
		this.h_ferme = h_ferme;
	}


	@Override
	public String toString() {
		return "Journee [id=" + id + ", nom=" + nom + ", h_ouvert=" + h_ouvert + ", h_ferme=" + h_ferme
				+ ", disponible=" + disponible + "]";
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public Journee(String nom, int h_ouvert, int h_ferme, boolean disponible) {
		super();
		this.nom = nom;
		this.h_ouvert = h_ouvert;
		this.h_ferme = h_ferme;
		this.disponible = disponible;
	}


	
	
	
	
	
}
