package com.chouchou.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "OFFRE")
public class Offre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OFFRE_ID")
	private Long id;
	
	@Column(name="TITRE_OFFRE")
	private String titre;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DATE_DEBUT")
	private Date date_debut;
	
	@Column(name="DATE_FIN")
	private Date date_fin;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="NOMBRE_PLACE")
	private int nbre_place;
	
	@Column(name="REMISE")
	private int remise;
	
	@OneToMany(orphanRemoval=false)
	@JoinTable(name = "OFFRE_SERVICE", joinColumns = @JoinColumn(name = "FK_OFFRE_ID", referencedColumnName = "OFFRE_ID"),
	inverseJoinColumns = @JoinColumn(name = "FK_SERVICE_ID", referencedColumnName = "SERVICE_ID"))
	private List<Service> services;

	public Offre() {
		super();
	}

	public Offre(String titre, String description, Date date_debut, Date date_fin, String image, int nbre_place,
			int remise, List<Service> services) {
		super();
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.image = image;
		this.nbre_place = nbre_place;
		this.remise = remise;
		this.services = services;
	}

	public Offre(Long id, String titre, String description, Date date_debut, Date date_fin, String image,
			int nbre_place, int remise, List<Service> services) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.image = image;
		this.nbre_place = nbre_place;
		this.remise = remise;
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbre_place() {
		return nbre_place;
	}

	public void setNbre_place(int nbre_place) {
		this.nbre_place = nbre_place;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", titre=" + titre + ", description=" + description + ", date_debut=" + date_debut
				+ ", date_fin=" + date_fin + ", image=" + image + ", nbre_place=" + nbre_place + ", remise=" + remise
				+ ", services=" + services + "]";
	}
	
	
	

}
