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
import javax.persistence.Table;

@Table(name="MENU")
@Entity
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="NOM_MENU")
	private String name;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="ICON")
	private String icon;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_role", joinColumns = @JoinColumn(name = "fk_menu_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fk_role_id", referencedColumnName = "id_role"))
	private List<Role> roles;
	
	
	
	

	public Menu(String name, String url, String icon, List<Role> roles) {
		super();
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.roles = roles;
	}

	public Menu(long id, String name, String url, String icon, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.roles = roles;
	}

	public Menu() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", icon=" + icon + ", roles=" + roles + "]";
	}
	
	
	
}
	