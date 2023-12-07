package com.lib.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="historique")
public class Historique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Long idhistorique;
	
	@OneToOne
	@JoinColumn(name="client")
	private Client id_client;

	public Long getIdhistorique() {
		return idhistorique;
	}

	public void setIdhistorique(Long idhistorique) {
		this.idhistorique = idhistorique;
	}

	public Client getId_client() {
		return id_client;
	}

	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}
	
	
	

}
