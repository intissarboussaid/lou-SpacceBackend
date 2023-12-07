package com.lib.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long idCommande;
	
	@Column
	String status;/*(en attend, en cours, terminée)*/
	@Column
	Date date;
	@ManyToMany
	Set<Client>  cmd;
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Client> getCmd() {
		return cmd;
	}
	public void setCmd(Set<Client> cmd) {
		this.cmd = cmd;
	}
	public Commande(String status, Date date, Set<Client> cmd) {
		super();
		this.status = status;
		this.date = date;
		this.cmd = cmd;
	}
	
	
	
	

}
