package com.lib.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="panier")
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id_panier;
	@Column
	int  nombre;
	@Column
	float total;
	@OneToOne
	  @JoinColumn(name = "client_fk")
	Client idclient;

	@OneToMany
	 private List<Clothes> clothes = new ArrayList<>();
	@OneToMany
	 private List<Decoration> decorations = new ArrayList<>();
	public Long getId_panier() {
		return id_panier;
	}
	public void setId_panier(Long id_panier) {
		this.id_panier = id_panier;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Client getIdclient() {
		return idclient;
	}
	public void setIdclient(Client idclient) {
		this.idclient = idclient;
	}

	public List<Clothes> getClothes() {
		return clothes;
	}
	public void setClothes(List<Clothes> clothes) {
		this.clothes = clothes;
	}
	public List<Decoration> getDecorations() {
		return decorations;
	}
	public void setDecorations(List<Decoration> decorations) {
		this.decorations = decorations;
	}
	public Panier(int nombre, float total, Client idclient, List<Clothes> clothes,
			List<Decoration> decorations) {
		super();
		this.nombre = nombre;
		this.total = total;
		this.idclient = idclient;

		this.clothes = clothes;
		this.decorations = decorations;
	}

	
	
}
