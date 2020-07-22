package com.chouchou.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIE")
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORIE_ID")
	private Long id;
	
	@Column(name="NOM_CATEGORIE")
	private String nom;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne
	private Image image_web;
	
	@OneToOne	
	private Image image_mobile;
	
	

	
	
	
	public Categorie() {
		super();
	}
	
	

	


	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}






	public Categorie(String nom, String description, Image image_web, Image image_mobile) {
		super();
		this.nom = nom;
		this.description = description;
		this.image_web = image_web;
		this.image_mobile = image_mobile;
	}

	





	public Categorie(Long id, String nom, String description, Image image_web, Image image_mobile) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.image_web = image_web;
		this.image_mobile = image_mobile;
	
	}






	public Image getImage_web() {
		return image_web;
	}



	public void setImage_web(Image image_web) {
		this.image_web = image_web;
	}



	public Image getImage_mobile() {
		return image_mobile;
	}



	public void setImage_mobile(Image image_mobile) {
		this.image_mobile = image_mobile;
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
		return "Categorie [id=" + id + ", nom=" + nom + ", description=" + description + ", image_web=" + image_web
				+ ", image_mobile=" + image_mobile +  "]";
	}

	
	
	
	
	

}
