package com.lib.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Decoration")
public class Decoration  {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long idDeco;
	 @Column
	 int quantite;
	@Column
	int rest_Stocke;
	 @Column
	    String detail;
	 @Column
	    String brand;
	 @Column
	    float price;
	 @Column
	    String description;
	 @Column
	    String photo;
	 @Column
	    String video;
	 @Column
	    String name;
	 @ManyToOne
	 @JoinColumn(name="Admin")
	    private Admin admin;
	public Long getIdDeco() {
		return idDeco;
	}
	public void setIdDeco(Long idDeco) {
		this.idDeco = idDeco;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getRest_Stocke() {
		return rest_Stocke;
	}
	public void setRest_Stocke(int rest_Stocke) {
		this.rest_Stocke = rest_Stocke;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Decoration(Long idDeco, int quantite, int rest_Stocke, String detail, String brand, float price,
			String description, String photo, String video, String name, Admin admin) {
		super();
		this.idDeco = idDeco;
		this.quantite = quantite;
		this.rest_Stocke = rest_Stocke;
		this.detail = detail;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.video = video;
		this.name = name;
		this.admin = admin;
	}
	public Decoration() {
		super();
	}
	public Decoration(int quantite, int rest_Stocke, String detail, String brand, float price, String description,
			String photo, String video, String name, Admin admin) {
		super();
		this.quantite = quantite;
		this.rest_Stocke = rest_Stocke;
		this.detail = detail;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.video = video;
		this.name = name;
		this.admin = admin;
	}
	
	

}
