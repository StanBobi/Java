package lab4;


class Imprimanta extends Fol_hartia{
	
	private int p_car;
	String rezolutie;
	private Mod mod_scriere;

	Imprimanta() {
	}

	Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, Stare s, int ppm, String rezolutie, int p_car, Mod mod_scriere) {
		super(denumire, nr_inv, pret, zona_mag, s, ppm);
		this.mod_scriere = mod_scriere;
		this.rezolutie = rezolutie;
		this.p_car = p_car;
	}

	Imprimanta(Imprimanta e) {
		this(e.getDenumire(), e.getNr_inv(), e.getPret(), e.getZona_mag(), e.getS(), e.getPpm(), e.rezolutie, e.p_car,
				e.mod_scriere);
	}

	public String getRezolutie() {
		return rezolutie;
	}

	public int getP_car() {
		return p_car;
	}

	public Mod getMod_scriere() {
		return mod_scriere;
	}
	
	public void setMod_scriere(Mod mod_scriere) {
		this.mod_scriere = mod_scriere;
	}

	public String toString() {
		return super.toString() + " " + rezolutie + " " + p_car + " " + mod_scriere;
	}

}
