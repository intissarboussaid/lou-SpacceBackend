package com.lib.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Favoris")
public class Favoris {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id_favoris;
	
	@OneToOne
	Admin idAdmin;

	public Long getId_favoris() {
		return id_favoris;
	}

	public void setId_favoris(Long id_favoris) {
		this.id_favoris = id_favoris;
	}

	public Admin getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Admin idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Favoris(Long id_favoris, Admin idAdmin) {
		super();
		this.id_favoris = id_favoris;
		this.idAdmin = idAdmin;
	}
	
	

}
