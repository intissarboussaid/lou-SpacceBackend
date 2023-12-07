package com.lib.models;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "productphoto")
public class ProductsPhoto   {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Lob
  private String name;

  
  private String type;

  @Lob
  private byte[] data;
  @ManyToOne
  @JoinColumn(name="idproduct", nullable=false)
  private Product product;
  
 
	public ProductsPhoto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public ProductsPhoto(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductsPhoto(String id, String name, String type, byte[] data, Product product) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
		this.product = product;
		
	}




	

}

