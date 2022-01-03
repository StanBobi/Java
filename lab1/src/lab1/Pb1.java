package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pb1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader flux_in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Lungime = ");
		String x = flux_in.readLine();

		System.out.print("Latime = ");
		String y = flux_in.readLine();

		int a = Integer.parseInt(x);
		int b = Integer.parseInt(y);

		System.out.print("\nPerimetru : " + 2*(a + b) + "\n" + "Aria : " + (a * b));

	}

}
