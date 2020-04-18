package com.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Ruoka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	private String tyyppi;
	private String allergeenit;
	private double hinta;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "ravintolaId")
	private Ravintola ravintola;
	public Ruoka() {
		
	}
	
	public Ruoka(String nimi, String tyyppi, String allergeenit, double hinta, Ravintola ravintola) {
		super();
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.allergeenit = allergeenit;
		this.hinta = hinta;
		this.ravintola = ravintola;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public String getAllergeenit() {
		return allergeenit;
	}

	public void setAllergeenit(String allergeenit) {
		this.allergeenit = allergeenit;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	

	public Ravintola getRavintola() {
		return ravintola;
	}

	public void setRavintola(Ravintola ravintola) {
		this.ravintola = ravintola;
	}

	@Override
	public String toString() {
		if (this.ravintola != null)
		return "Ruoka [id=" + id + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", allergeenit=" + allergeenit
				+ ", hinta=" + hinta + ", ravintola=" + this.getRavintola() + "]";
		else
			return "Ruoka [id=" + id + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", allergeenit=" + allergeenit
					+ ", hinta=" + hinta + "]";
	}

}
