package lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

class Vers {
	private String vers;
	private Random ran = new Random();

	public Vers() {} //constructorul fara parametru

	public Vers(String vers) { //constructorul cu parametru
		this.vers = vers;     
		ModificareVers();      //va genera un nr, pe baza caruia va modifica sau nu sirul    
	}

	public int getNumarCuvinte() { //metoda care returneaza numarul de cuvinte
		String[] Cuvant = new String[10];

		Cuvant = vers.split(" ");

		return Cuvant.length;
	}

	public String getVers() { //metoda care returneaza versul
		return vers; 
	}

	public int getNumarVocale() {
		int numarVocale = 0;
		String versCopiat = new String(vers);

		versCopiat = versCopiat.toUpperCase();   //se va folosi un sir secundar care, va fi modificat in litere mari pentru a cauta mai usor vocalele

		for (int i = 0; i < vers.length(); i++) {

			if(versCopiat.charAt(i) == 'A' || versCopiat.charAt(i) == 'E' || versCopiat.charAt(i) == 'I' || versCopiat.charAt(i) == 'O' || versCopiat.charAt(i) == 'U' ) numarVocale++;
		if(versCopiat.charAt(i) == 'Ã' || versCopiat.charAt(i) == 'Î' || versCopiat.charAt(i) == 'Â') numarVocale++;
		   //O metoda mai simpla 
		//if("AEIOUÃÂÎ".indexOf(versCopiat.charAt(i)) != -1) numarVocale++;
		}
		return numarVocale;   //calculeaza numarul de vocale
	}

	public int getNumarConsoane() {
		int numarConsoane = 0;
		String versCopiat = new String(vers);

		versCopiat = versCopiat.toUpperCase();   //se va folosi un sir secundar care, va fi modificat in litere mari pentru a cauta mai usor vocalele

		for (int i = 0; i < vers.length(); i++)
			if("AEIOUÃÂÎ".indexOf(versCopiat.charAt(i)) == -1) numarConsoane++;
		
		return numarConsoane;   //calculeaza numarul de vocale
	}
	
	//Am adaugat vers.length() > text.length()
	public String getCautare(String text)
	{
		if(vers.length() >= text.length() && vers.lastIndexOf(text) == (vers.length() - text.length())) return "*";
		else return "";    //verifica pozitia subsirului cautat(daca a fost gasit) in sir
	}

	private void ModificareVers()
	{
		if(ran.nextDouble() < 0.1) vers = vers.toUpperCase();     //folosim o metoda din clasa Random, nextDouble care genereaza nr intre 0 si 1
		//iar apoi daca acesta este <0.1 se va modifac sirul
	}

}

public class Problema1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String linie, text;
		BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("cantec_in.txt"))); //citirea din fisier

		BufferedReader bufCitire = new BufferedReader(new InputStreamReader(System.in));     
		System.out.print("Ce doriti sa cautati la finalul randului ? ");
		text = bufCitire.readLine();  //Citirea textului pentru finalul de linie unde se va pune *

		PrintStream flux_out = new PrintStream("cantec_out.txt");		//fisier afisare

		while (buf.ready()) {
			linie = buf.readLine();

			Vers v = new Vers(linie);
			
            //Am adaugat metoda getNumarConsoane
			if(v.getNumarCuvinte() == 1 && v.getNumarVocale() == 0 && v.getNumarConsoane() == 0) flux_out.println(v.getVers());  //nu se iau in considerare spatiile albe
			else flux_out.println("Cuvinte : " + v.getNumarCuvinte() + " V : " + v.getNumarVocale() + " " + v.getVers() + " "+v.getCautare(text));
		
		}

		flux_out.close();
		buf.close();
	}

}


