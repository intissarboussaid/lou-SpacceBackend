package com.lib.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avis")
public class Avis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id_avis;
	
	@Column
	float nombre;
    @Column
    String emoji;
	public Long getId_avis() {
		return id_avis;
	}
	public void setId_avis(Long id_avis) {
		this.id_avis = id_avis;
	}
	public float getNombre() {
		return nombre;
	}
	public void setNombre(float nombre) {
		this.nombre = nombre;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	public Avis(float nombre, String emoji) {
		super();
		this.nombre = nombre;
		this.emoji = emoji;
	}
    
    
}
