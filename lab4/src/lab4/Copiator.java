package lab4;

import java.io.Serializable;

class Copiator extends Fol_hartia implements Serializable{
	private int p_ton;
	Format format;

	Copiator() {
	}

	Copiator(String denumire, int nr_inv, float pret, String zona_mag, Stare s, int ppm, int p_ton, Format format) {
		super(denumire, nr_inv, pret, zona_mag, s, ppm);
		this.format = format;
		this.p_ton = p_ton;
	}

	Copiator(Copiator e) {
		this(e.getDenumire(), e.getNr_inv(), e.getPret(), e.getZona_mag(), e.getS(), e.getPpm(), e.p_ton, e.format);
	}

	public int getP_ton() {
		return p_ton;
	}

	public Format getFormat() {
		return format;
	}
	
	public void setFormat(Format format)
	{
		this.format = format;
	}

	public String toString() {
		return super.toString() + " " + p_ton + " " + format;
	}

}