package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader citire_sir = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sir1 = new StringBuilder();  //sirul original
		StringBuilder sir2 = new StringBuilder();  //sirul de introdus
		String sir;  //sirul citit
		int val = 0, val2; //lungimea si pozitia de start a stergerii

		while(val!=-1) //se foloseste o bucla pentru testare
		{
			System.out.print("Sir : " );
			sir = citire_sir.readLine();

			sir1 = new StringBuilder(sir);
			System.out.println("Ati introdus : " + sir1);

			System.out.print("Sir de introdus : " );
			sir = citire_sir.readLine();
			sir2 = new StringBuilder(sir);

			System.out.print("La pozitia : " );
			sir = citire_sir.readLine();
			val = Integer.parseInt(sir); 

			if(val == -1) break; //se opreste in cazul in care au fost introduse valori eronate

			sir1.insert(val, sir2);
			System.out.println("Rezultat : " + sir1);    

			System.out.println("De unde sa inceapa stergerea ? ");
			sir = citire_sir.readLine();
			val = Integer.parseInt(sir);

			if(val == -1) break;                           //se opreste in cazul in care au fost introduse valori eronate

			System.out.println("Cat de lunga ? ");
			sir = citire_sir.readLine();
			val2 = Integer.parseInt(sir); 

			if(val2 == -1 || val +val2 >= sir1.length() || val2 >= sir1.length()) break;   //se opreste in cazul in care au fost introduse valori eronate

			sir1.delete(val, val+val2);	                    //sterge din sir de la pozitia data, pe lungimea data
			System.out.println("Rezultat : " + sir1);

		}

	}

}
