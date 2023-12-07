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
@Table(name="Clothes")
public class Clothes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long IdClothes;
    @Column
    String detail;
    @Column
    float price;
    @Column
    String description;
    @Column
    String photo;
    @Column
    String video;
    @Column
    String brand;
    @Column
    String type;
    @Column
    String gendre;
    @Column
    int quantite;
    @Column
    float rest;
    
    @ManyToOne
    @JoinColumn(name="Admin")
    private Admin admin;
    
	public Long getIdClothes() {
		return IdClothes;
	}
	public void setIdClothes(Long idClothes) {
		IdClothes = idClothes;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getRest() {
		return rest;
	}
	public void setRest(float rest) {
		this.rest = rest;
	}

	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGendre() {
		return gendre;
	}
	public void setGendre(String gendre) {
		this.gendre = gendre;
	}
	public Clothes() {
		super();
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Clothes(Admin admin) {
		super();
		this.admin = admin;
	}
	public Clothes(String detail, float price, String description, String photo, String video, String brand,
			String type, String gendre, int quantite, float rest, Admin admin) {
		super();
		this.detail = detail;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.video = video;
		this.brand = brand;
		this.type = type;
		this.gendre = gendre;
		this.quantite = quantite;
		this.rest = rest;
		this.admin = admin;
	}
	
	
    
    


}
