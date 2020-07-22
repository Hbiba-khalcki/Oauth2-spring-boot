package com.chouchou.model;

import java.io.Serializable;

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
@Table(name = "PRODUIT")
public class Produit implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUIT_ID")
	private Long id;
	
	@Column(name="CODE_PRODUIT")
	private String code_produit;
	
	@Column(name="NOM_PRODUIT")
	private String nom;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRIX_VENTE")
	private float prix_vente;
	
	@Column(name="PRIX_PROMO")
	private float prix_promo;
	
	@Column(name="QTE")
	private int QTE;
	
	@Column(name="TVA")
	private float TVA;
	
		
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "FK_FOURNISSEUR_ID", referencedColumnName = "FOURNISSEUR_ID")
	private Fournisseur fournisseur;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "FK_MARQUE_ID", referencedColumnName = "MARQUE_ID")
	private Marque marque;

	public Produit() {
		super();
	}





	public Produit(String code_produit, String nom, String description, float prix_vente, float prix_promo, int qTE,
			float tVA, Fournisseur fournisseur, Marque marque) {
		super();
		this.code_produit = code_produit;
		this.nom = nom;
		this.description = description;
		this.prix_vente = prix_vente;
		this.prix_promo = prix_promo;
		QTE = qTE;
		TVA = tVA;
		this.fournisseur = fournisseur;
		this.marque = marque;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_produit() {
		return code_produit;
	}

	public void setCode_produit(String code_produit) {
		this.code_produit = code_produit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public float getPrix_vente() {
		return prix_vente;
	}



	public void setPrix_vente(float prix_vente) {
		this.prix_vente = prix_vente;
	}



	public float getPrix_promo() {
		return prix_promo;
	}



	public void setPrix_promo(float prix_promo) {
		this.prix_promo = prix_promo;
	}



	public int getQTE() {
		return QTE;
	}

	public void setQTE(int qTE) {
		QTE = qTE;
	}

	public float getTVA() {
		return TVA;
	}

	public void setTVA(float tVA) {
		TVA = tVA;
	}





	public Produit(Long id, String code_produit, String nom, String description, float prix_vente, float prix_promo,
			int qTE, float tVA, Fournisseur fournisseur, Marque marque) {
		super();
		this.id = id;
		this.code_produit = code_produit;
		this.nom = nom;
		this.description = description;
		this.prix_vente = prix_vente;
		this.prix_promo = prix_promo;
		QTE = qTE;
		TVA = tVA;
		this.fournisseur = fournisseur;
		this.marque = marque;
	}

	
	
	
	
	
	
	

}
