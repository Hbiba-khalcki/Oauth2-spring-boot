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
@Table(name = "FOURNISSUER")
public class Fournisseur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOURNISSEUR_ID")
	private Long id;

	@Column(name = "fourniseuur")
	private String fournisseur;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "NOM_FOURNISSEUR")
	private String nomFournisseur;

	@Column(name = "PRENOM_FOURNISSEUR")
	private String prenomFournisseur;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEPHONE_MOBILE")
	private String telephoneMobile;

	@Column(name = "TELEPHONE_FIXE")
	private String telephoneFixe;

	@Column(name = "WEBSITE")
	private String website;

	@Column(name = "ADRESSE")
	private String adresse;

	@Column(name = "Suburb")
	private String suburb;

	@Column(name = "ville")
	private String ville;

	@Column(name = "gouvernerat")
	private String gouvernerat;

	@Column(name = "Post_Code")
	private String postCode;

	@Column(name = "pays")
	private String pays;

	@Column(name="DATE_UPDATE")
	private Date dateMiseAJour;
	
	public Fournisseur() {
		super();
	}
 
	public Fournisseur(Long id, String fournisseur, String description, String nomFournisseur, String prenomFournisseur,
			String email, String telephoneMobile, String telephoneFixe, String website, String adresse, String suburb,
			String ville, String gouvernerat, String postCode, String pays, Date dateMiseAJour) {
		super();
		this.id = id;
		this.fournisseur = fournisseur;
		this.description = description;
		this.nomFournisseur = nomFournisseur;
		this.prenomFournisseur = prenomFournisseur;
		this.email = email;
		this.telephoneMobile = telephoneMobile;
		this.telephoneFixe = telephoneFixe;
		this.website = website;
		this.adresse = adresse;
		this.suburb = suburb;
		this.ville = ville;
		this.gouvernerat = gouvernerat;
		this.postCode = postCode;
		this.pays = pays;
		this.dateMiseAJour = dateMiseAJour;
	}




	public Fournisseur(String fournisseur, String description, String nomFournisseur, String prenomFournisseur,
			String email, String telephoneMobile, String telephoneFixe, String website, String adresse, String suburb,
			String ville, String gouvernerat, String postCode, String pays, Date dateMiseAJour) {
		super();
		this.fournisseur = fournisseur;
		this.description = description;
		this.nomFournisseur = nomFournisseur;
		this.prenomFournisseur = prenomFournisseur;
		this.email = email;
		this.telephoneMobile = telephoneMobile;
		this.telephoneFixe = telephoneFixe;
		this.website = website;
		this.adresse = adresse;
		this.suburb = suburb;
		this.ville = ville;
		this.gouvernerat = gouvernerat;
		this.postCode = postCode;
		this.pays = pays;
		this.dateMiseAJour = dateMiseAJour;
	}




	public Date getDateMiseAJour() {
		return dateMiseAJour;
	}


	public void setDateMiseAJour(Date dateMiseAJour) {
		this.dateMiseAJour = dateMiseAJour;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getPrenomFournisseur() {
		return prenomFournisseur;
	}

	public void setPrenomFournisseur(String prenomFournisseur) {
		this.prenomFournisseur = prenomFournisseur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getGouvernerat() {
		return gouvernerat;
	}

	public void setGouvernerat(String gouvernerat) {
		this.gouvernerat = gouvernerat;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", fournisseur=" + fournisseur + ", description=" + description
				+ ", nomFournisseur=" + nomFournisseur + ", prenomFournisseur=" + prenomFournisseur + ", email=" + email
				+ ", telephoneMobile=" + telephoneMobile + ", telephoneFixe=" + telephoneFixe + ", website=" + website
				+ ", adresse=" + adresse + ", suburb=" + suburb + ", ville=" + ville + ", gouvernerat=" + gouvernerat
				+ ", postCode=" + postCode + ", pays=" + pays + ", dateMiseAJour=" + dateMiseAJour + "]";
	}

 
}