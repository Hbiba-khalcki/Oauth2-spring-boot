package com.chouchou.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MARQUE")
public class Marque implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MARQUE_ID")
	private Long id;
	
	@Column(name="NOM_MARQUE")
	private String nom_marque;
	
	@Column(name="DATE_UPDATE")
	private Date date_miseAJour;
	
 
	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marque(String nom_marque) {
		super();
		this.nom_marque = nom_marque;
	}

	public Marque(Long id, String nom_marque) {
		super();
		this.id = id;
		this.nom_marque = nom_marque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	 
	public Date getDate_miseAJour() {
		return date_miseAJour;
	}

	public void setDate_miseAJour(Date date_miseAJour) {
		this.date_miseAJour = date_miseAJour;
	}

	@Override
	public String toString() {
		return "Marque [id=" + id + ", nom_marque=" + nom_marque + ", date_miseAJour=" + date_miseAJour + "]";
	}
 

}
