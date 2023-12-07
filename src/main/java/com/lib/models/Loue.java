package com.lib.models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="louer")
public class Loue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id_louer;

}
