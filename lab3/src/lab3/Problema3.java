package lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problema3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("judete_in.txt"))); //citirea din fisier
		BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in)); //citirea de la tastatura

		String [] linie = new String[41]; //vector de string-uri
		int i = 0;                       // contor in vector

		while(buf.ready())             //cititrea sirurilor
		{
			linie[i] = buf.readLine();
			System.out.println(i + " " + linie[i]);
			i++;
		}

		Arrays.sort(linie);           //sortarea cu metoda sort din Clasa Arrays
 
		System.out.println("Sir de cautat : ");
		String sir_de_cautat = buf1.readLine(); //citeste un judet de la tastatura 
		
		if(Arrays.binarySearch(linie, sir_de_cautat) != -1) System.out.print(Arrays.binarySearch(linie, sir_de_cautat) ); //returneaza pozitia acestuia
		else System.out.print("Judetul nu a fost gasit");
		
		buf1.close();
		buf.close();	
	}

}
