package lab5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


public class Banca {

	private String denumire_banca;
	private List<Client> clienti;

	Banca(){}

	Banca(String denumire_banca)
	{
		this.denumire_banca = denumire_banca;
		clienti = new ArrayList<Client>();
	}

	Banca(String denumire_banca, List<Client> clienti)
	{
		this.denumire_banca = denumire_banca;
		this.clienti = clienti;
	}

	Banca(Banca e)
	{
		this(e.getDenumire_banca(), e.getClienti());
	}

	public String getDenumire_banca() {
		return denumire_banca;
	}

	public List<Client> getClienti() {
		return clienti;
	}

	public String returneazaClienti()
	{
		return clienti.toString();
	}

	void adaugaClient(String nume, String adresa)
	{
		clienti.add(new Client(nume, adresa));	
	}

	public String adaugaCont(String nume, String numarCont, float suma, String moneda, Calendar data1, Calendar data2)
	{
		Iterator<Client> i= clienti.iterator(); 

        while(i.hasNext())
		{
			Client contPentruClientul = i.next();
			if(contPentruClientul.getNume().equals(nume))
			{
				if(contPentruClientul.adaugaCont(numarCont, suma, moneda, data1, data2) == 0) return "Clientul are deja 5 conturi\n";
				else return "Adaugare efectuata cu succes\n";
			}
		 }
        return "Clientul nu a fost gasit\n";
	}

	public void afiseaza()
	{
		System.out.println(clienti);	
	}

	public String toString()
	{
		return "\n---Nume banca---\n" + denumire_banca + "\n---Client---\n" + returneazaClienti() + "\n";	
	}


}
