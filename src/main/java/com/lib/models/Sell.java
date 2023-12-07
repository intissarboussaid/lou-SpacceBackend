package com.lib.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sell")
public class Sell {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id_sell;
}
