package com.lib.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MakeUp")
public class MakeUp  {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idmakeUp;
	
	@Column
	String brand;
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
    int quantite;
    @Column
    int rest_Stocke;
    
    
	public Long getIdmakeUp() {
		return idmakeUp;
	}

	public void setIdmakeUp(Long idmakeUp) {
		this.idmakeUp = idmakeUp;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public MakeUp(String brand, String detail, float price, String description, String photo, String video,
			int quantite, int rest_Stocke) {
		super();
		this.brand = brand;
		this.detail = detail;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.video = video;
		this.quantite = quantite;
		this.rest_Stocke = rest_Stocke;
	}

	

}
