package com.chouchou.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TYPE_ENTREPRISE")
public class TypeEntreprise implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TYPE_ENTREPRISE_ID")
	private Long id;
	
	@Column(name="NOM_TYPE")
	private String nom;

	public TypeEntreprise() {
		super();
	}

	public TypeEntreprise(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public TypeEntreprise(String nom) {
		super();
		this.nom = nom;
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

	@Override
	public String toString() {
		return "TypeEntreprise [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
