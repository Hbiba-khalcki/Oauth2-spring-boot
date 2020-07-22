package com.chouchou.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chouchou.model.Enum.TypePaiement;

@Entity
@Table(name = "SALON")
public class Salon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SALON_ID")
	private Long id;

	@Column(name = "NOM_SALON")
	private String nom;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "TELEHPONE")
	private String telephone;

	@Column(name = "LONGITUDE")
	private double longitude;

	@Column(name = "LATITUDE")
	private double latitude;

	@Column(name = "FREELANCER")
	private boolean freelancer;

	@Column(name = "SEXE")
	private String sexe;

	@ManyToOne(optional = true)
	@JoinColumn(name="TYPE_ENTREPRISE_ID")
	private TypeEntreprise type_entreprise;

	@Column
	@Enumerated
	@ElementCollection(targetClass = TypePaiement.class)
	private List<TypePaiement> type_paiement;

	@OneToMany(orphanRemoval = true,fetch=FetchType.LAZY)
	@JoinTable(name = "SALON_SERVICE", joinColumns = @JoinColumn(name = "FK_SALON_ID", referencedColumnName = "SALON_ID"), inverseJoinColumns = @JoinColumn(name = "FK_SERVICE_ID", referencedColumnName = "SERVICE_ID"))
	private List<Service> services;

	@OneToMany(orphanRemoval = true)
	@JoinTable(name = "SALON_OFFRE", joinColumns = @JoinColumn(name = "FK_SALON_ID", referencedColumnName = "SALON_ID"), inverseJoinColumns = @JoinColumn(name = "FK_OFFRE_ID", referencedColumnName = "OFFRE_ID"))
	private List<Offre> offres;

	@OneToMany(orphanRemoval = true)
	@JoinTable(name = "SALON_AVIS", joinColumns = @JoinColumn(name = "FK_SALON_ID", referencedColumnName = "SALON_ID"), inverseJoinColumns = @JoinColumn(name = "FK_AVIS_ID", referencedColumnName = "AVIS_ID"))
	private List<Rating> avis;
	
	@OneToMany(orphanRemoval = true)
	@JoinTable(name = "SALON_STAFF", joinColumns = @JoinColumn(name = "FK_SALON_ID", referencedColumnName = "SALON_ID"), inverseJoinColumns = @JoinColumn(name = "FK_USER_ID", referencedColumnName = "USER_ID"))
	private List<UserManager> staff;
	
	
	
	public List<UserManager> getStaff() {
		return staff;
	}




	public void setStaff(List<UserManager> staff) {
		this.staff = staff;
	}




	@OneToOne(orphanRemoval = true)
	private Journee lundi;
	@OneToOne(orphanRemoval = true)
	private Journee mardi;
	@OneToOne(orphanRemoval = true)
	private Journee mercredi;
	@OneToOne(orphanRemoval = true)
	private Journee jeudi;
	@OneToOne(orphanRemoval = true)
	private Journee vendredi;
	@OneToOne(orphanRemoval = true)
	private Journee samedi;
	@OneToOne(orphanRemoval = true)
	private Journee dimanche;





	public Salon() {
		super();
	}
	
	
	

	




	public Salon(String nom, String description, String telephone, double longitude, double latitude,
				 boolean freelancer, String sexe, TypeEntreprise type_entreprise, List<TypePaiement> type_paiement,
				 List<Service> services, List<Offre> offres, List<Rating> avis, List<UserManager> staff, Journee lundi,
				 Journee mardi, Journee mercredi, Journee jeudi, Journee vendredi, Journee samedi, Journee dimanche) {
		super();
		this.nom = nom;
		this.description = description;
		this.telephone = telephone;
		this.longitude = longitude;
		this.latitude = latitude;
		this.freelancer = freelancer;
		this.sexe = sexe;
		this.type_entreprise = type_entreprise;
		this.type_paiement = type_paiement;
		this.services = services;
		this.offres = offres;
		this.avis = avis;
		this.staff = staff;
		this.lundi = lundi;
		this.mardi = mardi;
		this.mercredi = mercredi;
		this.jeudi = jeudi;
		this.vendredi = vendredi;
		this.samedi = samedi;
		this.dimanche = dimanche;
	}




	public Salon(Long id, String nom, String description, double longitude, double latitude, boolean freelancer,
			String sexe, TypeEntreprise type_entreprise, List<TypePaiement> type_paiement, List<Service> services,
			List<Offre> offres, List<Rating> avis) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.freelancer = freelancer;
		this.sexe = sexe;
		this.type_entreprise = type_entreprise;
		this.type_paiement = type_paiement;
		this.services = services;
		this.offres = offres;
		this.avis = avis;
	}




	public Salon(String nom, String description, double longitude, double latitude, boolean freelancer, String sexe,
				 TypeEntreprise type_entreprise, List<TypePaiement> type_paiement, List<Service> services,
				 List<Offre> offres, List<Rating> avis, Journee lundi, Journee mardi, Journee mercredi, Journee jeudi,
				 Journee vendredi, Journee samedi, Journee dimanche) {
		super();
		this.nom = nom;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.freelancer = freelancer;
		this.sexe = sexe;
		this.type_entreprise = type_entreprise;
		this.type_paiement = type_paiement;
		this.services = services;
		this.offres = offres;
		this.avis = avis;
		this.lundi = lundi;
		this.mardi = mardi;
		this.mercredi = mercredi;
		this.jeudi = jeudi;
		this.vendredi = vendredi;
		this.samedi = samedi;
		this.dimanche = dimanche;
	}




	public Salon(String nom, String description, double longitude, double latitude, boolean freelancer, String sexe,
				 TypeEntreprise type_entreprise, List<TypePaiement> type_paiement, List<Service> services,
				 List<Offre> offres, List<Rating> avis, List<UserManager> staff, Journee lundi, Journee mardi,
				 Journee mercredi, Journee jeudi, Journee vendredi, Journee samedi, Journee dimanche) {
		super();
		this.nom = nom;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.freelancer = freelancer;
		this.sexe = sexe;
		this.type_entreprise = type_entreprise;
		this.type_paiement = type_paiement;
		this.services = services;
		this.offres = offres;
		this.avis = avis;
		this.staff = staff;
		this.lundi = lundi;
		this.mardi = mardi;
		this.mercredi = mercredi;
		this.jeudi = jeudi;
		this.vendredi = vendredi;
		this.samedi = samedi;
		this.dimanche = dimanche;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public boolean isFreelancer() {
		return freelancer;
	}

	public void setFreelancer(boolean freelancer) {
		this.freelancer = freelancer;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public TypeEntreprise getType_entreprise() {
		return type_entreprise;
	}

	public void setType_entreprise(TypeEntreprise type_entreprise) {
		this.type_entreprise = type_entreprise;
	}

	public List<TypePaiement> getType_paiement() {
		return type_paiement;
	}

	public void setType_paiement(List<TypePaiement> type_paiement) {
		this.type_paiement = type_paiement;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	

	public List<Rating> getAvis() {
		return avis;
	}




	public Journee getLundi() {
		return lundi;
	}




	public void setLundi(Journee lundi) {
		this.lundi = lundi;
	}




	public Journee getMardi() {
		return mardi;
	}




	public void setMardi(Journee mardi) {
		this.mardi = mardi;
	}




	public Journee getMercredi() {
		return mercredi;
	}




	public void setMercredi(Journee mercredi) {
		this.mercredi = mercredi;
	}




	public Journee getJeudi() {
		return jeudi;
	}




	public void setJeudi(Journee jeudi) {
		this.jeudi = jeudi;
	}




	public Journee getVendredi() {
		return vendredi;
	}




	public void setVendredi(Journee vendredi) {
		this.vendredi = vendredi;
	}




	public Journee getSamedi() {
		return samedi;
	}




	public void setSamedi(Journee samedi) {
		this.samedi = samedi;
	}




	public Journee getDimanche() {
		return dimanche;
	}




	public void setDimanche(Journee dimanche) {
		this.dimanche = dimanche;
	}




	public void setAvis(List<Rating> avis) {
		this.avis = avis;
	}




	@Override
	public String toString() {
		return "Salon [id=" + id + ", nom=" + nom + ", description=" + description + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", freelancer=" + freelancer + ", sexe=" + sexe + ", type_entreprise="
				+ type_entreprise + ", type_paiement=" + type_paiement + ", services=" + services + ", offres=" + offres
				+ ", avis=" + avis + ", staff=" + staff + ", lundi=" + lundi + ", mardi=" + mardi + ", mercredi="
				+ mercredi + ", jeudi=" + jeudi + ", vendredi=" + vendredi + ", samedi=" + samedi + ", dimanche="
				+ dimanche + "]";
	}




	
	
	
	

}
