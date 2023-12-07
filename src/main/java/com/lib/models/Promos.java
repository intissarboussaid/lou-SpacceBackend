package com.lib.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="promos")
public class Promos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id_promos;
	
	@Column 
	Date date_debut;

	@Column 
	Date date_fin;

	@Column 
	String event;
	@Column 
	String name;
	public Long getId_promos() {
		return id_promos;
	}
	public void setId_promos(Long id_promos) {
		this.id_promos = id_promos;
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
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Promos(Date date_debut, Date date_fin, String event, String name) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.event = event;
		this.name = name;
	}
	
	
	

}
