package lab4;

import java.io.Serializable;

class Echipament implements Serializable{
	
	private String denumire;
	private int nr_inv;
	private float pret;
	private String zona_mag;
	private Stare s;
    
	// Constructori
	Echipament(String denumire, int nr_inv, float pret, String zona_mag, Stare s) {
		this.denumire = denumire;
		this.nr_inv = nr_inv;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.s = s;
	}

	Echipament() {
	}

	Echipament(Echipament e) {
		this(e.getDenumire(), e.getNr_inv(), e.getPret(), e.getZona_mag(), e.getS());
	}

	// Getters
	public String getDenumire() {
		return denumire;
	}

	public int getNr_inv() {
		return nr_inv;
	}

	public float getPret() {
		return pret;
	}

	public String getZona_mag() {
		return zona_mag;
	}

	public Stare getS() {
		return s;
	}

	public String toString() {
		return denumire + " " + nr_inv + " " + pret + " " + zona_mag + " " + s + " ";
	}
	
	public void setS(Stare S)
	{
     this.s = S;
	}
	
}
