package Cartile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ComparaTitlu implements Comparator
{
	public int compare(Object o1, Object o2)
	{
     return(((Carte)o1).getTitlu().compareTo(((Carte)o2).getTitlu()));		
	}
}


public class pb2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Map
		Map<Integer, Carte> carte = new HashMap<Integer, Carte>();
		

		//Citire Fisier
		BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));	
		String linie;
		String []cuvinte = new String[4];

		while(buf.ready())
		{
			linie = buf.readLine();
			cuvinte = linie.split("; ");
			carte.put(Carte.getId(), new Carte(cuvinte[1], cuvinte[2], Integer.parseInt(cuvinte[3])));

		}

		//Afisare - 1
		System.out.println(carte + " \n");
		
		
		//Afisare - 2
		
		Set s = carte.entrySet();
		Iterator it = s.iterator();
			
		while(it.hasNext())
		{
        Entry e = (Entry)it.next();
        
        System.out.print("Cheia : " + e.getKey());
        // Carte c = (Carte)e.getValue();
        // System.out.println(" Cartea: " + c);
        
        System.out.println(" Cartea: " + (Carte)e.getValue());
		}
		
		
		//Crearea Listei si adaugarea in aceasta
		List<Carte> lista_Carti = new ArrayList<Carte>();
		
		it = s.iterator();
		
		while(it.hasNext())
		{
			Entry e = (Entry)it.next();
			
			Carte book = (Carte)e.getValue();
			
			lista_Carti.add(new Carte(book.getTitlu(), book.getAutor(), book.getAn_aparitie()));
		}
		
		//Afisarea listei
		System.out.println("\n" + lista_Carti + "\n");
		
		//Afisarea listei - 2
		
		Iterator<Carte> itc = lista_Carti.iterator();
		
	    while(itc.hasNext())
	    {
	    	Carte book = itc.next();
	    	System.out.println(book.getTitlu() + " " + book.getAutor() + " " + book.getAn_aparitie()); 	
	    }
	    
	    Collections.sort(lista_Carti,new ComparaTitlu());
	    
	    System.out.println(lista_Carti);

		buf.close();
	}

}
