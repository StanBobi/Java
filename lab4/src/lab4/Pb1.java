package lab4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum Stare {
	achizitionat, expus, vandut
}

enum Format {
	A4, A3
}

enum Mod {
	color, albnegru
}

enum Sist_operare {
	instalWin, instalLinux
}

class Operatii // se putea face fara clasa Operatii
{                                              // direct in main, dar pentru a arata mai bine s-a folosit o clasa separata
	public static Object citeste (String fis)  //metodele sunt statice pentru a fi accesate cu numele clasei.
	{
		try {
			FileInputStream f = new FileInputStream(fis);	//Fisierul in care se va scrie
			ObjectInputStream ois = new ObjectInputStream(f); //Buffer de nivel inalt

			Object o = ois.readObject();                    //metoda din clasa ObjectInputStream pentru citire (aici se deserializeaza)

			ois.close();
			f.close();

			return o;
		}
		catch(IOException | ClassNotFoundException e)
		{
			e.printStackTrace();	
		}
		return null;
	}
	
	public static void scrie(Object o, String fis)
	{
	  try {
		  FileOutputStream f = new FileOutputStream(fis);     //Fisierul in care se va scrie
		  ObjectOutputStream oos = new ObjectOutputStream(f); //buffer de nivel inalt
		   
		  oos.writeObject(o);                                 //metoda din clasa ObjectInputStream pentru scriere (aici se serializeaza)

		  oos.close();
		  f.close();
	  }
	  catch(IOException e)
	  {
		e.printStackTrace();  
	  }
	}

}

public class Pb1{

	static void citeste_imprimanta(String l[], Echipament []e, int nr)
	{
		String denumire = l[0];
		int nr_inv = Integer.parseInt(l[1]);
		float pret = Float.parseFloat(l[2]);
		String zona_mag = l[3];
		Stare s = Stare.valueOf(l[4]);
		int ppm = Integer.parseInt(l[6]);
		String rezolutie =l[7];
		int p_car = Integer.parseInt(l[8]);
		Mod mod = Mod.valueOf(l[9].toLowerCase());

		e[nr]  = new Imprimanta(denumire, nr_inv, pret, zona_mag, s, ppm, rezolutie, p_car, mod); //instantiaza obiectul din vectorul e (tip echipament)
  	                                                                                              //cu indicele nr, cu o clasa de tip imprimanta  
                                                                                                  //cast explicit
	}
		static void citeste_copiator(String l[], Echipament []e, int nr)
	{
		String denumire = l[0];
		int nr_inv = Integer.parseInt(l[1]);
		float pret = Float.parseFloat(l[2]);
		String zona_mag = l[3];
		Stare s = Stare.valueOf(l[4]);
		int ppm = Integer.parseInt(l[6]);
		int p_ton = Integer.parseInt(l[7]);
		Format format = Format.valueOf(l[8]);

		e[nr]  = new Copiator(denumire, nr_inv, pret, zona_mag, s, ppm, p_ton, format);//instantiaza obiectul din vectorul e (tip echipament)
  	                                                                                  //cu indicele nr, cu o clasa de tip copiator
                                                                                       //cast explicit
	}
	
	static void citeste_sist_calcul(String l[], Echipament []e, int nr)
	{
		String denumire = l[0];
		int nr_inv = Integer.parseInt(l[1]);
		float pret = Float.parseFloat(l[2]);
		String zona_mag = l[3];
		Stare s = Stare.valueOf(l[4]);

		String tip_mon = l[6];
		float vit_proc = Float.parseFloat(l[7]);
		int c_hdd = Integer.parseInt(l[8]);
		Sist_operare sist;
		if(l[9].toLowerCase().equals("linux")) sist = Sist_operare.instalLinux;
		else sist = Sist_operare.instalWin; 

		e[nr]  = new Sist_calcul(denumire, nr_inv, pret, zona_mag, s, tip_mon, vit_proc, c_hdd, sist);//instantiaza obiectul din vectorul e (tip echipament)
  	                                                                                                  //cu indicele nr, cu o clasa de tip imprimanta  
                                                                                                      //cast explicit
	}

	public static void mesaj()
	{
		System.out.println("1)  Afiºarea imprimantelor"); 
		System.out.println("2)  Afiºarea copiatoarelor");
		System.out.println("3)  Afiºarea sistemelor de calcul");
		System.out.println("4)  Modificarea stãrii în care se aflã un echipament");
		System.out.println("5)  Setarea unui anumit mod de scriere pentru o imprimantã");
		System.out.println("6)  Setarea unui format de copiere pentru copiatoare");
		System.out.println("7)  Instalarea unui anumit sistem de operare pe un sistem de calcul");
		System.out.println("8)  Afiºarea echipamentelor vândute");
		System.out.println("9)  Salveaza in fisier");
		System.out.println("10) Citeste si afiseaza fisierul");
		System.out.println("0) STOP");
		System.out.println("Optiunea dumneavoastra : ");
	}

	public static void afisare(String val, Echipament e[], int nr)
	{
		for(int i = 0; i < nr; i++)
		{
            
			//Verifica la fiecare obiect din vector, tipul sau (cu care a fost instantiat elementul respectiv)
			//si valoarea primita ca parametru (i - imprimante, c - copiatoare, s - sist de calcul, v - toate echipamentele vandute, " " afiseaza tot)
			if(e[i] instanceof Imprimanta && val.equals("i")) 	System.out.println(e[i]);
			else if(e[i].getClass().getTypeName().equals("lab4.Copiator") && val.equals("c")) System.out.println(e[i]);
			else if(e[i].getClass().getTypeName().equals("lab4.Sist_calcul") && val.equals("s")) System.out.println(e[i]);
			else if(val.equals("v") && e[i].getS().equals(Stare.vandut)) System.out.println(e[i]);
			else if(val.equals(" ")) System.out.println(e[i]);
		}

		System.out.print("\n\n");
	}
  
	public static void seteaza(Echipament []e, int nr_ec, String nume, String linie, String tip)
	{
		for(int i = 0; i < nr_ec; i++)
		{
			//verifica fiecare element daca are tipul dat si denumirea (parametrii)
			//daca da, se va apela setter-ul corespunzator, daca linia face parte din enum
			if((nume.equals(e[i].getDenumire())) && (e[i] instanceof Imprimanta) && (tip.equals("i")))
			{
				if(linie.toLowerCase().equals("color")) ((Imprimanta)e[i]).setMod_scriere(Mod.color);
				else if(linie.toLowerCase().equals("albnegru")) ((Imprimanta)e[i]).setMod_scriere(Mod.albnegru);  
			}

			else if((nume.equals(e[i].getDenumire())) && (e[i] instanceof Copiator) && (tip.equals("c")))
			{
				if(linie.toLowerCase().equals("a3")) ((Copiator)e[i]).setFormat(Format.A3); 
				else if(linie.toLowerCase().equals("a4")) ((Copiator)e[i]).setFormat(Format.A4);  
			}

			else if((nume.equals(e[i].getDenumire())) && (e[i] instanceof Sist_calcul) && (tip.equals("s")))
			{
				if(linie.toLowerCase().equals("windows")) ((Sist_calcul)e[i]).setSist(Sist_operare.instalWin);
				else if(linie.toLowerCase().equals("linux")) ((Sist_calcul)e[i]).setSist(Sist_operare.instalLinux);
			}

		}

	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("electronice.txt")));
		String linie;
		String []l = new String[10];
		int nr_ec = 0;
		Echipament []e = new Echipament[20];

		while(buf.ready())
		{
			linie = buf.readLine();
			l = linie.split(";");

            //la fiecare linie, se va verifica cuvantul al 6-lea, ce tip este si se va merge pe ramura corespunzatoare
			
			if(l[5].equals(("imprimanta").toLowerCase())) citeste_imprimanta(l, e, nr_ec);
			else if(l[5].equals(("copiator").toLowerCase())) citeste_copiator(l, e, nr_ec);
			else if(l[5].equals(("sistem de calcul").toLowerCase())) citeste_sist_calcul(l, e, nr_ec);
 
			nr_ec++; //contorizarea vectorului
		}

		int opt = 0;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String nume;

		do {
			mesaj();	
			linie = in.readLine();
			opt = Integer.parseInt(linie);			
			System.out.println("\n");

			switch(opt)
			{
			default : System.out.println("Nu exista aceasta optiune\n");break;
			case 0 : break;

			case 1 : afisare("i", e, nr_ec);
			break;
			case 2 : afisare("c", e, nr_ec);
			break;
			case 3 : afisare("s", e, nr_ec);
			break;

			case 4 : System.out.print("Nume echipament : ");nume = in.readLine();
			System.out.print("Stare : ");linie = in.readLine();

			for(int i = 0; i<nr_ec; i++)
			{
				if(e[i].getDenumire().equals(nume))
				{
					if((linie).toLowerCase().equals("achizitionat")) e[i].setS(Stare.achizitionat); 
					else if((linie).toLowerCase().equals("vandut"))  e[i].setS(Stare.vandut);
					else if((linie).toLowerCase().equals("expus")) e[i].setS(Stare.expus);

				}
			}
			break;

			case 5 : System.out.print("Nume imprimanta : ");nume = in.readLine();
			System.out.print("Mod de scriere : ");linie = in.readLine();
			seteaza(e, nr_ec, nume, linie, "i");
			break;

			case 6 : System.out.print("Nume copiator : ");nume = in.readLine();
			System.out.print("Format copiere : ");linie = in.readLine();
			seteaza(e, nr_ec, nume, linie, "c");
			break;

			case 7 : System.out.print("Nume sistem de calcul: ");nume = in.readLine();
			System.out.print("Sistem de operare : ");linie = in.readLine();
			seteaza(e, nr_ec, nume, linie, "s");     
			break;

			case 8 : afisare("v", e, nr_ec);
			break;

			case 9 : Operatii.scrie(e, "echip.bin"); break;
			
			case 10 : Echipament []e2 = new Echipament[20];
			e2 = (Echipament[]) Operatii.citeste("echip.bin");
			afisare(" ", e2, nr_ec);
			 break;

			}

		}while(opt != 0);

		buf.close();
	}

}
