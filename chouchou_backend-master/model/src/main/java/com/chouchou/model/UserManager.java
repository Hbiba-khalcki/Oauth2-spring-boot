package com.chouchou.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.chouchou.model.Enum.Sexe;

@Entity
@Table(name = "USER")
public class UserManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name = "DATE_NAISSANCE")
	private Date date_naissance;
	@Column(name = "TELEPHON")
	private String tel;
	@Column(name = "ADRESSE")
	private String adresse;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "SEXE")
	private Sexe sexe;
	
	@OneToOne(orphanRemoval=true,fetch=FetchType.EAGER)
	private Salon salon;

    
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "FK_USER_ID", referencedColumnName = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID", referencedColumnName = "ID_ROLE"))
	private List<Role> roles;
	
	

	


	public UserManager(String nom, String prenom, String login, String password, Date date_naissance, String tel,
			String adresse, String image, Sexe sexe, Salon salon, List<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.date_naissance = date_naissance;
		this.tel = tel;
		this.adresse = adresse;
		this.image = image;
		this.sexe = sexe;
		this.salon = salon;
		this.roles = roles;
	}

	
	
	public UserManager(Long id, String nom, String prenom, String login, String password, Date date_naissance,
			String tel, String adresse, String image, Sexe sexe, Salon salon, List<Role> roles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.date_naissance = date_naissance;
		this.tel = tel;
		this.adresse = adresse;
		this.image = image;
		this.sexe = sexe;
		this.salon = salon;
		this.roles = roles;
	}



	@Enumerated(EnumType.STRING)
	private AuthProvider provider;

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	private String providerId;
	public Salon getSalon() {
		return salon;
	}



	public void setSalon(Salon salon) {
		this.salon = salon;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public UserManager() {
		super();
	}

	public UserManager(String nom, String prenom, String login, String password, Date date_naissance, String tel,
			String adresse, String image, Sexe sexe, List<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.date_naissance = date_naissance;
		this.tel = tel;
		this.adresse = adresse;
		this.image = image;
		this.sexe = sexe;
		this.roles = roles;
	}

	public UserManager(Long id, String nom, String prenom, String login, String password, Date date_naissance,
			String tel, String adresse, String image, Sexe sexe, List<Role> roles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.date_naissance = date_naissance;
		this.tel = tel;
		this.adresse = adresse;
		this.image = image;
		this.sexe = sexe;
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "UserManager [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + ", date_naissance=" + date_naissance + ", tel=" + tel + ", adresse=" + adresse + ", image="
				+ image + ", sexe=" + sexe + ", salon=" + salon + ", roles=" + roles + "]";
	}

	

	

}
