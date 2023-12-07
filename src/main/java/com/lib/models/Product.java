package com.lib.models;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product5")
public class Product {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 long idproduct;
	 
	 @Column
	 String detail;
	 
	 @Column
	 String ref;
	 
	 @Column
	 String color;
	
	 @Column
	 String size;
	
	 @Column
	 String collection;
	
	 @Column
	 int rest_stock;

	 @Column
	 float  productDiscountedPrice;
	 
	 @Column
	 float  productActualPrice;
	 
	 @Column
	 String producDescription;
	 
	 @Column
	 String brand;
	
	 @Column
	 String productName;
	 
	 @Column
	 int quantite;
	 
	 @ManyToOne
	 @JoinColumn(name="Admin")
	 private Admin admin;
	  
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinTable(name = "fileDB", 
			  joinColumns = @JoinColumn(name = "idproduct"), 
			  inverseJoinColumns = @JoinColumn(name = "id"))
	 private Set<FileDB> fileDB;


	public long getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(long idproduct) {
		this.idproduct = idproduct;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public int getRest_stock() {
		return rest_stock;
	}

	public void setRest_stock(int rest_stock) {
		this.rest_stock = rest_stock;
	}

	public float getProductDiscountedPrice() {
		return productDiscountedPrice;
	}

	public void setProductDiscountedPrice(float productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}

	public float getProductActualPrice() {
		return productActualPrice;
	}

	public void setProductActualPrice(float productActualPrice) {
		this.productActualPrice = productActualPrice;
	}

	public String getProducDescription() {
		return producDescription;
	}

	public void setProducDescription(String producDescription) {
		this.producDescription = producDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
	 


	public Set<FileDB> getImagesProduct() {
		return fileDB;
	}

	public void setImagesProduct(Set<FileDB> imagesProduct1) {
		fileDB = imagesProduct1;
	}

	public Product() {
		super();
	}
	

}
