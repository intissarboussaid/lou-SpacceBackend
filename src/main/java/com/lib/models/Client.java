package com.lib.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(	name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id_client;
	 String tel;
	 String adresse;
	 String firstName;
	 String lastname;
	 String codepostale;
	 String localisation;
	 
	 
	@OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "idaccount")
	 private Account account;

	public long getId_client() {
		return id_client;
	}


	public void setId_client(long id_client) {
		this.id_client = id_client;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getCodepostale() {
		return codepostale;
	}


	public void setCodepostale(String codepostale) {
		this.codepostale = codepostale;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Client(String tel, String adresse, String firstName, String lastname, String codepostale,
			String localisation) {
		super();
		this.tel = tel;
		this.adresse = adresse;
		this.firstName = firstName;
		this.lastname = lastname;
		this.codepostale = codepostale;
		this.localisation = localisation;
	}


	public Client(Account account) {
		super();
		this.account=account;
	}
	public Client() {
		super();
		
	}


	

}
