package lab5;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Client{

	private String nume;
	private String adresa;
	private Set<ContBancar> cont;

	public Client(){}

	public Client(String nume, String adresa)
	{
		this.nume = nume; 
		this.adresa = adresa;
		this.cont = new HashSet<ContBancar>();
	}

	public Client(String nume, String adresa, Set<ContBancar> cont)
	{
		this.nume = nume; 
		this.adresa = adresa;
		this.cont = cont;
	}

	public Client(Client e)
	{
		this(e.getNume(), e.getAdresa() ,e.getCont());
	}

	public String getNume() {
		return nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public Set<ContBancar> getCont() {
		return cont;
	}

	
	public int adaugaCont(String numarCont, float suma, String moneda, Calendar data1, Calendar data2)
	{
	    if(cont.size() > 4) return 0; 	
	    
	    cont.add(new ContBancar(numarCont, suma, moneda, data1, data2));
	    return cont.size();
	    
	}

	public String returneazaConturi()
	{
	   return cont.toString();	
    }
	

	public String toString()
	{
		return "Nume: " + nume + "; Adresa: " + adresa + "\n---Conturi---\n" + returneazaConturi() ;
	}
}
