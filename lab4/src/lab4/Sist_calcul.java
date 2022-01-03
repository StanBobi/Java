package lab4;

import java.io.Serializable;

class Sist_calcul extends Echipament implements Serializable{
	private String tip_mon;
	private float vit_proc;
	private int c_hdd;
	private Sist_operare sist;

	Sist_calcul() {
	}

	Sist_calcul(String denumire, int nr_inv, float pret, String zona_mag, Stare s, String tip_mon, float vit_proc,
			int c_hdd, Sist_operare sist) {
		super(denumire, nr_inv, pret, zona_mag, s);
		this.c_hdd = c_hdd;
		this.sist = sist;
		this.vit_proc = vit_proc;
		this.tip_mon = tip_mon;
	}

	Sist_calcul(Sist_calcul e) {
		this(e.getDenumire(), e.getNr_inv(), e.getPret(), e.getZona_mag(), e.getS(), e.tip_mon, e.vit_proc, e.c_hdd,
				e.sist);
	}

	public String getTip_mon() {
		return tip_mon;
	}

	public float getVit_proc() {
		return vit_proc;
	}

	public int getC_hdd() {
		return c_hdd;
	}

	public Sist_operare getSist() {
		return sist;
	}
	
	public void setSist(Sist_operare sist)
	{
		this.sist = sist;
	}

	public String toString() {
		return super.toString() + " " + tip_mon + " " + vit_proc + " " + c_hdd + " " + sist;
	}

}
