package com.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Ravintola {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ravintolaId;
	private String ravintolaNimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ravintola")
	@JsonBackReference
	private List<Ruoka> ruoat;
	
	private String kuvaus;
	private String sijainti;
	private int arvosana;
	
	public Ravintola() {
		
	}
	public Ravintola(String ravintolaNimi, String kuvaus, String sijainti, int arvosana) {
		super();
		this.ravintolaNimi = ravintolaNimi;
		this.kuvaus = kuvaus;
		this.sijainti = sijainti;
		this.arvosana = arvosana;
	}
	public Long getRavintolaId() {
		return ravintolaId;
	}
	public void setRavintolaId(Long ravintolaId) {
		this.ravintolaId = ravintolaId;
	}
	public String getRavintolaNimi() {
		return ravintolaNimi;
	}
	public void setRavintolaNimi(String ravintolaNimi) {
		this.ravintolaNimi = ravintolaNimi;
	}
	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	public String getSijainti() {
		return sijainti;
	}
	public void setSijainti(String sijainti) {
		this.sijainti = sijainti;
	}
	public int getArvosana() {
		return arvosana;
	}
	public void setArvosana(int arvosana) {
		this.arvosana = arvosana;
	}
	@Override
	public String toString() {
		return "Ravintola [ravintolaId=" + ravintolaId + ", ravintolaNimi=" + ravintolaNimi + ", kuvaus=" + kuvaus
				+ ", sijainti=" + sijainti + ", arvosana=" + arvosana + "]";
	}
	
	
}
