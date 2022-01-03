package lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Melodie {
	private String artist, nume;
	private int an;
	private long views;

	public Melodie(String nume, String artist, int an, long views) // constructori
	{
		this.artist = artist;
		this.nume = nume;
		this.an = an;
		this.views = views;
	}

	public Melodie(Melodie p)
	{
		this(p.getNume(), p.getArtist(), p.getAn(), p.getViews());
	}

	public Melodie() {
	}

	public String getArtist() { // gett-ere
		return artist;
	}

	public String getNume() {
		return nume;
	}

	public int getAn() {
		return an;
	}

	public long getViews() {
		return views;
	}

	public String toString() // metoda to string modificata pentru afisare
	{
		return nume + " " + artist + " " + an + " " + views + " vizionari";
	}

}

public class Problema4 {

	public static void main(String[] args) throws IOException {

		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt"))); // fisierul
		                                                                                                   // din care
		                                                                                                   // se
		                                                                                                   // citeste
		String linie; // linia din fisier
		String[] cuvinte_linie = new String[4]; // vector pentru impartirea liniei
		Melodie[] song = new Melodie[20]; // vector de obiecte pentru melodii
		int contor = 0; // contor

		// citirea din fisier
		while (flux_in.ready()) {
			linie = flux_in.readLine(); // citeste o linie
			cuvinte_linie = linie.split(" "); // ia fiecare rand si il imparte

			song[contor] = new Melodie(cuvinte_linie[0], cuvinte_linie[1], Integer.parseInt(cuvinte_linie[2]),
					Long.parseLong(cuvinte_linie[3]));
			// se apeleaza constructorul

			contor++; // incrementeaza constructorul
		}

		int opt = 0;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String artist;
		Melodie aux = new Melodie();  //variabila de interschimbare

		loop: while (true) // folosesc o bucla pentru celelalte 3 optiuni
		{
			System.out.println("1 - Afiºeazã informaþiile melodiilor încãrcate");
			System.out.println("2 - Afiºeazã clasamentul melodiilor în ordine descrescãtoare al numãrului de vizualizãri pe youtube");
			System.out.println("3 - Afiºeazã toate melodiile unui artist");
			System.out.println("0 - Iesire");

			System.out.print("Optiunea dumneavoastra : ");  //citeste optiunea
			opt = Integer.parseInt(buf.readLine());
			System.out.print("\n"); 

			switch (opt) {

			case 2: 
				for(int i = 0; i < contor-1; i++)
				{
					for(int j = i+1; j<contor; j++)
					{
						if(song[i].getViews()<song[j].getViews())  //datorita faptului ca o sa se sorteze in functie 
						{                                          //de an, se va face sortarea manual
							aux = new Melodie(song[i]);            //Cazul 2 nu are un break la final, pentru afisare va merge direct
							song[i] = new Melodie(song[j]);        //in cazul 1 unde are loc deja o afisare
							song[j] = new Melodie(aux);
						}
					}
				}

			case 1:
				for (int i = 0; i < contor; i++) {
					System.out.println(i+1 + ") " + song[i]);      //afisarea melodiilor incarcate
				}
				break;

			case 3: System.out.print("Artist : ");
			artist = buf.readLine();
			for (int i = 0; i < contor; i++) {
				if((song[i].getArtist()).equals(artist)) System.out.println(song[i]);      //afisarea melodiilor incarcate
			}

			break;

			default:System.out.println("Nu exista aceasta optiune");
			break;

			case 0 : break loop; //opreste bucla
			}

			System.out.print("\n");

		}

		flux_in.close();

	}
}
