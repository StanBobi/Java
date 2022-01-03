package lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

class Produse {
	private double pret;
	private int cantitate;
	private String nume;

	public Produse(String nume, double pret, int cantitate) {
		this.pret = pret;
		this.cantitate = cantitate;
		this.nume = nume;
	}

    public Produse(Produse p)
    {
    	this(p.nume, p.pret, p.cantitate);
    }
	
	public double getPret() {
		return pret;
	}

	public String getNume() {
		return nume;
	}

	public int getCantitate() {
		return cantitate;
	}

	public String toString() {
		return (nume + " " + pret + " " + cantitate); // afisare sub forma tabelara
	}

}

public class Problema2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));

		String text;

		System.out.printf("%-10s %-10s %-4s", "Denumire", "Pret (lei)", "Cantitate\n");// informatii privind tabelul

		// Produsele cu pretul minimi/maxim va fi salvat intr-un obiect separat
		Produse pret_minim = new Produse("", Double.MAX_VALUE, 0);
		Produse pret_maxim = new Produse("", 0.0, 0);

		Produse[] produs = new Produse[20]; // se creeaza un vector de produse pentru elementele citite
		int nr = 0;

		while (in.ready()) {
			text = in.readLine(); // citeste textul

			String[] text_impartit = text.split(";"); // imparte textul

			double pret = Double.parseDouble(text_impartit[1]); // atribuie fiecare parte citita tipului corespunzator
			int cantitate = Integer.parseInt(text_impartit[2]);
			String nume = text_impartit[0];

			System.out.printf("%-10s %-10s %-4s\n", nume, pret, cantitate); // afisare sub forma tabelara

			if (pret < pret_minim.getPret())
				pret_minim = new Produse(nume, pret, cantitate);
			if (pret > pret_maxim.getPret())
				pret_maxim = new Produse(nume, pret, cantitate);

			produs[nr] = new Produse(nume, pret, cantitate); // produs[i] primeste valorile gasite
			nr++; // astfel incat fiecare element citit are propriul obiect
		}

		PrintStream flux_out = new PrintStream("out.txt"); // afisarea in fisierul "out.txt"
		flux_out.println(pret_minim.getNume() + " " + pret_minim.getPret() + " " + pret_minim.getCantitate());
		flux_out.println(pret_maxim); //pret_maxim.toString()
 
		int cantitate_citita; // se va citi de la tastatura o cantitate
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("\nCantitatea maxima (0 - STOP) : ");   //la 0 programul se opreste
			cantitate_citita = scanner.nextInt();

			for (int i = 0; i < nr; i++) {
				if (cantitate_citita > produs[i].getCantitate())    // se verifica obiectele pana la nr-1
					System.out.println(produs[i]);
			}

		} while (cantitate_citita != 0);

		scanner.close();
		in.close(); // inchiderea fisierelor
		flux_out.close();
	}

}
