package lab2;

class Parabola {
	private double a, b, c;

	public Parabola(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Parabola(Parabola p) {
		this(p.a, p.b, p.c);
	}

	public void afisare_functie() {
		System.out.println("f(x) = a x^2 + b x + c = " + a + "*x^2 + " + b + "*x + " + c);
	}

	public double[] Coordonate_Varf() {
		double[] v = new double[2];

		v[0] = -1 * b / (2 * a); //coord. x ale varfului
		v[1] = ((-1 * (b * b)) + (4 * a * c)) / (4 * a);

		return v;
	}

	static public double[] mijlocul_segmentului(Parabola x, Parabola y) {
		double[] mijloc = new double[2];
		double[] p1 = new double[2]; // doi vectori pentru coordonatele celor 2 puncte
		double[] p2 = new double[2];

		System.arraycopy(x.Coordonate_Varf(), 0, p1, 0, 2); // se calculeaza coordonatele primului punct
		System.arraycopy(y.Coordonate_Varf(), 0, p2, 0, 2); // --//-- celui de-al 2 lea punct

		mijloc[0] = (p1[0] + p2[0]) / 2; // se calculeaza mijlocul segmentului de dreapta
		mijloc[1] = (p1[1] + p2[1]) / 2; // pentru x respectiv y

		return mijloc;
	}

}

public class Problema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parabola p1 = new Parabola(1, 2, 3);

		p1.afisare_functie(); // afisarea functiei

		double[] v = new double[2]; // vector pentru punctele obtinute

		System.arraycopy(p1.Coordonate_Varf(), 0, v, 0, 2); // copiez rezultatul
		                                                    // functiei coordonate in vectorul v

		System.out.println("Coordonate : ( " + v[0] + " , " + v[1] + " );"); // afiseaza coordonatele parabolei

		Parabola p2 = new Parabola(p1); // creez un obiect la fel ca p1

		System.arraycopy(Parabola.mijlocul_segmentului(p1, p2), 0, v, 0, 2); // copiez rezultatul
		                                                                     // functiei mijlocul_segmentului
                                                                             // in vectorul v

		System.out.println("Mijlocul segment : ( " + v[0] + " , " + v[1] + " );");// afiseaza mijlocul segmentului

		Parabola p3 = new Parabola(5, 6, 5); // creez un obiect nou

		System.arraycopy(Parabola.mijlocul_segmentului(p1, p3), 0, v, 0, 2); // copiez rezultatul
		                                                                     // functiei mijlocul_segmentului
		                                                                     // in vectorul v

		System.out.println("Mijlocul segment : ( " + v[0] + " , " + v[1] + " );");// afiseaza mijlocul segmentului

	}

}
