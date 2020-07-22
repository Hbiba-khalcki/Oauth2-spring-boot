package com.chouchou.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RESERVATION_ID")
	private Long id;
	
	@Column(name="ADRESSE")
	private String adresse;
	
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="PRIX_TOTAL")
	private float prix_total;
	
	
	@OneToMany(orphanRemoval=false)
	@JoinTable(name = "RESERVATION_SERVICE", joinColumns = @JoinColumn(name = "FK_RESERVATION_ID", referencedColumnName = "RESERVATION_ID"),
	inverseJoinColumns = @JoinColumn(name = "FK_ARTICLE_ID", referencedColumnName = "ARTICLE_ID"))
	private List<Article> panier;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="OFFRE_ID")
	private Offre offre;

	
	public Reservation() {
		super();
	}
	
	

	public Reservation(String adresse, Date date, float prix_total, List<Article> panier, Offre offre) {
		super();
		this.adresse = adresse;
		this.date = date;
		this.prix_total = prix_total;
		this.panier = panier;
		this.offre = offre;
	}

	
	


	public Reservation(Long id, String adresse, Date date, float prix_total, List<Article> panier, Offre offre) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.date = date;
		this.prix_total = prix_total;
		this.panier = panier;
		this.offre = offre;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrix_total() {
		return prix_total;
	}

	public void setPrix_total(float prix_total) {
		this.prix_total = prix_total;
	}

	

	public List<Article> getPanier() {
		return panier;
	}



	public void setPanier(List<Article> panier) {
		this.panier = panier;
	}



	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}



	@Override
	public String toString() {
		return "Reservation [id=" + id + ", adresse=" + adresse + ", date=" + date + ", prix_total=" + prix_total
				+ ", panier=" + panier + ", offre=" + offre + "]";
	}

	
	
	
	
	

}
