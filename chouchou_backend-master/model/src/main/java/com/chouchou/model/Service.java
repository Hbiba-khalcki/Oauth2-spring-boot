package com.chouchou.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERVICE_ID")
	private Long id;

	@Column(name = "NOM_SERVICE")
	private String nom;

	@Column(name = "PRIX_VENTE")
	private float prix_vente;

	@Column(name = "PRIX_PROMO")
	private float prix_promo;

	@Column(name = "DUREE_SERVICE")
	private float duree_service;

	@Column(name = "SERVICE_POUR")
	private String ServicePour;

	@ManyToOne(fetch = FetchType.EAGER)
	private Categorie categorie;

//	@ManyToOne(fetch = FetchType.EAGER)
//	private UserManager partner;
	
	@ManyToOne
	private Salon salon;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "STAFF_SERVICE", joinColumns = @JoinColumn(name = "FK_SERVICE_ID", referencedColumnName = "SERVICE_ID"), inverseJoinColumns = @JoinColumn(name = "FK_USER_ID", referencedColumnName = "USER_ID"))
	private List<UserManager> employes;

	public Service() {
		super();
	}
	
	

	public Service(Long id, String nom, float prix_vente, float prix_promo, float duree_service, String servicePour,
			Categorie categorie, List<UserManager> employes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix_vente = prix_vente;
		this.prix_promo = prix_promo;
		this.duree_service = duree_service;
		ServicePour = servicePour;
		this.categorie = categorie;
		this.employes = employes;
	}



	public Service(String nom, float prix_vente, float prix_promo, float duree_service, String servicePour,
			Categorie categorie, List<UserManager> employes) {
		super();
		this.nom = nom;
		this.prix_vente = prix_vente;
		this.prix_promo = prix_promo;
		this.duree_service = duree_service;
		ServicePour = servicePour;
		this.categorie = categorie;
		this.employes = employes;
	}



	public Service(String nom, float prix_vente, float prix_promo, float duree_service, String servicePour,
			Categorie categorie, Salon salon, List<UserManager> employes) {
		super();
		this.nom = nom;
		this.prix_vente = prix_vente;
		this.prix_promo = prix_promo;
		this.duree_service = duree_service;
		ServicePour = servicePour;
		this.categorie = categorie;
		this.salon = salon;
		this.employes = employes;
	}



	public Service(Long id) {
		super();
		this.id = id;
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

	public float getDuree_service() {
		return duree_service;
	}

	public void setDuree_service(float duree_service) {
		this.duree_service = duree_service;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
//
//	public UserManager getPartner() {
//		return partner;
//	}
//
//	public void setPartner(UserManager partner) {
//		this.partner = partner;
//	}
//

	


	public String getServicePour() {
		return ServicePour;
	}




	public Salon getSalon() {
		return salon;
	}



	public void setSalon(Salon salon) {
		this.salon = salon;
	}



	public void setServicePour(String servicePour) {
		ServicePour = servicePour;
	}




	public List<UserManager> getEmployes() {
		return employes;
	}



	public void setEmployes(List<UserManager> employes) {
		this.employes = employes;
	}



	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + ", prix_vente=" + prix_vente + ", prix_promo=" + prix_promo
				+ ", duree_service=" + duree_service + ", ServicePour=" + ServicePour + ", categorie=" + categorie
				+ ", salon=" + salon + ", employes=" + employes + "]";
	}



	




	

}
