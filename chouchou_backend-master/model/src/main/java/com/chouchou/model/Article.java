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
@Table(name = "ARTICLE")
public class Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ARTICLE_ID")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "FK_SERVICE_ID", referencedColumnName = "SERVICE_ID")
	private Service service;
	
	@Column(name="QTE")
	private int qte;

	public Article() {
		super();
	}

	public Article(Service service, int qte) {
		super();
		this.service = service;
		this.qte = qte;
	}

	public Article(Long id, Service service, int qte) {
		super();
		this.id = id;
		this.service = service;
		this.qte = qte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
	
	
	
	
	
	
	

}
