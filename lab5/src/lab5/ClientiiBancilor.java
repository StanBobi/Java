package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

interface Operatiuni
{
	public float calculeaza_dobanda();
	public float actualizare_suma();
	public void depunere(float suma);
	public void extragere(float suma);
}



public class ClientiiBancilor{

	static void  adauga_banca(Vector<Banca> banca) throws IOException
	{
		System.out.print("Nume banca : ");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String nume_banca = buf.readLine();

		banca.add(new Banca(nume_banca));
	}

	static void adauga_cont(Vector<Banca> banca) throws IOException
	{
		System.out.print("Nume banca : ");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String nume_banca = buf.readLine();

		Iterator<Banca> i = banca.iterator();
		Banca banca_cautata;

		while(i.hasNext())
		{
			banca_cautata = i.next();

			if(banca_cautata.getDenumire_banca().equals(nume_banca) == true)
			{
				System.out.print("Nume beneficiar : ");
				String nume = buf.readLine();

				System.out.print("Numar cont : ");
				String numarCont = buf.readLine();

				System.out.print("Suma : ");
				float suma = Float.parseFloat(buf.readLine());

				String moneda;
				do {
					System.out.print("Moneda : ");
					moneda = buf.readLine();
				}while(moneda.equals("EUR") == false && moneda.equals("RON") == false);

				System.out.print("Zi : ");
				int zi_d = Integer.parseInt(buf.readLine());
				int luna_d;

				do {
					System.out.print("Luna : ");
					luna_d = Integer.parseInt(buf.readLine()) - 1; 
				}while(luna_d < 0 || luna_d > 12);

				System.out.print("An : ");
				int an_d = Integer.parseInt(buf.readLine()); 

				Calendar data_deschiderii = Calendar.getInstance();
				data_deschiderii.set(an_d, luna_d, zi_d);

				System.out.println(banca_cautata.adaugaCont(nume, numarCont, suma, moneda, data_deschiderii, data_deschiderii));
				return;
			}
		}
		System.out.println("Nu am gasit banca "+ nume_banca + " \n");

	}

	static void operatii_cont(Vector<Banca> banca, String operatiune) throws IOException
	{
		System.out.print("Nume banca : ");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String nume_banca = buf.readLine();

		Iterator<Banca> i = banca.iterator();
		Banca banca_cautata;

		while(i.hasNext())
		{
			banca_cautata = i.next();

			if(banca_cautata.getDenumire_banca().equals(nume_banca) == true)
			{
				Iterator<Client> it = banca_cautata.getClienti().iterator();
				Client cl;
				String nume_client, numarCont;
				float suma;

				System.out.print("Nume client : ");
				nume_client = buf.readLine();

				while(it.hasNext())
				{
					cl = it.next();

					if(cl.getNume().equals(nume_client) == true)
					{

						Iterator<ContBancar> itc = cl.getCont().iterator();
						System.out.print("NumarCont : ");
						numarCont = buf.readLine();

						while(itc.hasNext())
						{
							ContBancar cont = itc.next();
							if(cont.getNumarCont().equals(numarCont) == true)
							{
								cont.actualizare_suma();
								
								System.out.print("Suma : ");
								suma = Float.parseFloat(buf.readLine());
								if(operatiune.equals("depunere"))
								{
									cont.depunere(suma);
								}
								else if(operatiune.equals("extragere"))
								{
									cont.extragere(suma);
								}
								return;
							}
						}
						
						System.out.println("Nu am gasit nici un cont cu numarul : " + numarCont);
						return;
					}
				}
				System.out.println("Nu am gasit nici un client cu numele : " + nume_client);
				return;
			}
		}
		System.out.println("Nu am gasit nici o banca cu numele: " + nume_banca);
		return;
	}

	static void adauga_client(Vector<Banca> banca) throws IOException
	{
		System.out.print("Nume banca : ");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String nume_banca = buf.readLine();

		Iterator<Banca> i = banca.iterator();
		Banca banca_cautata;

		while(i.hasNext())
		{
			banca_cautata = i.next();

			if(banca_cautata.getDenumire_banca().equals(nume_banca) == true)
			{
				System.out.print("Nume : ");  
				String nume = buf.readLine();

				System.out.print("Adresa : ");  
				String adresa = buf.readLine();
				banca_cautata.adaugaClient(nume, adresa);
				return;
			}
		}
		System.out.println("Nu am gasit banca "+ nume_banca + " \n");

	}

	static void tranzactie(Vector<Banca> banca) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		String numeT, numeR, numeBancaT, numeBancaR, numarContT, numarContR;
		float suma;

		Iterator<Banca> it = banca.iterator();

		Banca banca_cautata1 = null, banca_cautata2 = null;

		System.out.print("Nume banca de unde se trimite : ");
		numeBancaT = buf.readLine();

		int ok = 0;
		while(it.hasNext())
		{
			banca_cautata1 = it.next();
			if(banca_cautata1.getDenumire_banca().equals(numeBancaT))
			{
				ok = 1;
				break;
			} 
		}

		if(ok == 0) 
		{
			System.out.println("Nu am gasit banca " + numeBancaT);
			return;
		}

		System.out.print("Nume banca care primeste : ");
		numeBancaR = buf.readLine();
		ok = 0;
		it = banca.iterator();

		while(it.hasNext())
		{
			banca_cautata2 = it.next();
			if(banca_cautata2.getDenumire_banca().equals(numeBancaR))
			{
				ok = 1;
				break;
			} 
		}
		if(ok == 0) 
		{
			System.out.println("Nu am gasit banca " + numeBancaR);
			return;
		}

		System.out.print("Nume : ");
		numeT = buf.readLine();
		ok = 0;

		Iterator<Client> itc = banca_cautata1.getClienti().iterator();
		Client transmitator = null, receptor = null;

		while(itc.hasNext())
		{
			transmitator = itc.next();
			if(transmitator.getNume().equals(numeT))
			{
				ok = 1;
				break;
			} 
		}
		if(ok == 0)
		{
			System.out.println("Nu am gasit clientul : " + numeT);
			return;
		}

		System.out.print("Nume beneficiar : ");
		numeR = buf.readLine();
		ok = 0;

		itc = banca_cautata2.getClienti().iterator();

		while(itc.hasNext())
		{
			receptor = itc.next();
			if(receptor.getNume().equals(numeR))
			{
				ok = 1;
				break;
			} 
		}
		if(ok == 0)
		{
			System.out.println("Nu am gasit clientul : " + numeR);
			return;
		}
		
		
        //Citire conturi
		ContBancar contT = null, contR = null;

		Iterator<ContBancar> itcb = transmitator.getCont().iterator();

		System.out.print("Numar cont : ");
		numarContT = buf.readLine();

		ok = 0;
		while(itcb.hasNext())
		{
			contT = itcb.next();

			if(contT.getNumarCont().equals(numarContT))
			{
				ok = 1;
				break;
			}
		}
		if(ok == 0)
		{
			System.out.println("Nu am gasit contul : " + numarContT);
			return;
		}
		

		itcb = receptor.getCont().iterator();

		System.out.print("Numar cont beneficiar : ");
		numarContR = buf.readLine();

		ok = 0;
		while(itcb.hasNext())
		{
			contR = itcb.next();

			if(contR.getNumarCont().equals(numarContR))
			{
				ok = 1;
				break;
			}
		}
		if(ok == 0)
		{
			System.out.println("Nu am gasit contul : " + numarContR);
			return;
		}
		
		
		//Verificare moneda
		if(contR.getMoneda().equals(contT.getMoneda()))
		{
		  //Se citeste suma
			System.out.print("Suma : ");
			contT.actualizare_suma();
			contR.actualizare_suma();
			suma = Float.parseFloat(buf.readLine());
		    if(contT.getSuma() >= suma)
		    {
		    	contT.extragere(suma);
		    	contR.depunere(suma);
		    }
		    else System.out.println("Exista doar " + contT.getSuma() +" " + contT.getMoneda() + " in cont");
		}
		else System.out.println("Conturile sunt in monede diferite");

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Vector<Banca> banca = new Vector<Banca>();  
		int optiune = 0; 

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String linie;
 
		do
		{
			System.out.println("1 - Adauga o banca");
			System.out.println("2 - Adauga un client la o banca");
			System.out.println("3 - Adauga un cont unui client");
			System.out.println("4 - Afiseaza datele");
			System.out.println("5 - Depune o suma intr-un cont");
			System.out.println("6 - Extrage bani dintr-un cont");
			System.out.println("7 - Transfer de bani intre doua conturi");
			System.out.println("0 - Iesire");
			System.out.print("    Optiunea dumneavoastra : ");
			do {
				linie = buf.readLine();

				optiune = -1;

				try {
					optiune = Integer.parseInt(linie);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Folositi cifre!\n");	
				}
			}while(optiune < 0);

			System.out.println("\n");


			switch(optiune)
			{
			case 0 : break;

			case 1 : adauga_banca(banca);break;

			case 2 : adauga_client(banca);break;

			case 3 : adauga_cont(banca);break;

			case 4 : System.out.println(banca);break; 

			case 5 : operatii_cont(banca, "depunere");break;

			case 6 : operatii_cont(banca, "extragere");break;

			case 7 : tranzactie(banca);break;

			default : System.out.println("Nu a fost gasita aceasta optiune");break;
			}


			System.out.println("");

		}while(optiune != 0);

		buf.close();
	}


}
