package com.lib.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Long idAdmin;
	@Column
	String nameCompany;
	@Column
	String adresseCompagnie;
	@Column
	 String tel;
	@Column
	 String adresseInsta;
	@Column
	 String firstName;
	@Column
	 String lastname;
	@Column
	 String codepostale;
	@Column
	 String adresseFb;
	@Column
	 String adresseEmail;
	@Column
	 String adresseTikTok;
	@OneToOne
	 Account account;
	

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getAdresseCompagnie() {
		return adresseCompagnie;
	}

	public void setAdresseCompagnie(String adresseCompagnie) {
		this.adresseCompagnie = adresseCompagnie;
	}




	public Admin() {
		super();
	}


	public Admin(Account account) {
		super();
		this.account = account;
	}



	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getAdresseInsta() {
		return adresseInsta;
	}

	public void setAdresseInsta(String adresseInsta) {
		this.adresseInsta = adresseInsta;
	}

	public String getAdresseFb() {
		return adresseFb;
	}

	public void setAdresseFb(String adresseFb) {
		this.adresseFb = adresseFb;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}

	public String getAdresseTikTok() {
		return adresseTikTok;
	}

	public void setAdresseTikTok(String adresseTikTok) {
		this.adresseTikTok = adresseTikTok;
	}

	public Admin(Long idAdmin, String nameCompany, String adresseCompagnie, String tel, String adresseInsta,
			String firstName, String lastname, String codepostale, String adresseFb, String adresseEmail,
			String adresseTikTok, Account account) {
		super();
		this.idAdmin = idAdmin;
		this.nameCompany = nameCompany;
		this.adresseCompagnie = adresseCompagnie;
		this.tel = tel;
		this.adresseInsta = adresseInsta;
		this.firstName = firstName;
		this.lastname = lastname;
		this.codepostale = codepostale;
		this.adresseFb = adresseFb;
		this.adresseEmail = adresseEmail;
		this.adresseTikTok = adresseTikTok;
		this.account = account;
	}


	
	

	
	
	
	
}
