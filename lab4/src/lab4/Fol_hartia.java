package lab4;

import java.io.Serializable;

class Fol_hartia extends Echipament implements Serializable{
	private int ppm;

	Fol_hartia() {
	}

	Fol_hartia(String denumire, int nr_inv, float pret, String zona_mag, Stare s, int ppm) {
		super(denumire, nr_inv, pret, zona_mag, s);
		this.ppm = ppm;
	}

	Fol_hartia(Fol_hartia e) {
		this(e.getDenumire(), e.getNr_inv(), e.getPret(), e.getZona_mag(), e.getS(), e.ppm);
	}

	public int getPpm() {
		return ppm;
	}

	public String toString() {
		return super.toString() + " " + ppm;
	}
}