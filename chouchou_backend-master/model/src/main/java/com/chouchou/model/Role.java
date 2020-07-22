package com.chouchou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="ROLE")
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ROLE")
	private Long id;
	
	@Column(name="NOM_ROLE")
	private String nomRole;
	
	@Column( name="description")
	private String description;
	
	
	
	public Role(Long id) {
		super();
		this.id = id;
	}
	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}
	public Role(Long id, String nomRole) {
		super();
		this.id = id;
		this.nomRole = nomRole;
	}
	
	
	public Role(Long id, String nomRole, String description) {
		super();
		this.id = id;
		this.nomRole = nomRole;
		this.description = description;
	}
	
	
	
	public Role(String nomRole, String description) {
		super();
		this.nomRole = nomRole;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	public Role() {
		super();
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", nomRole=" + nomRole + ", description=" + description + "]";
	}
	
	
	
	
	
}
