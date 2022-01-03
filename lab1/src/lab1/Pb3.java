package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pb3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader flux_in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("X = ");
		int x = Integer.parseInt(flux_in.readLine());

		int ok = 0;

		for (int i = 2; i <= x / 2; i++) {

			if (x % i == 0) {
				System.out.print(i + " ");
				ok = 1;
			}
		}

		if (ok == 0)
			System.out.println(x + " nu are divizori comuni");

	}
}
