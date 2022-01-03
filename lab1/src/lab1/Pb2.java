package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Pb2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(new File("in.txt"));

		int minim = Integer.MAX_VALUE;
		int maxim = Integer.MIN_VALUE;
		int i = 0, suma = 0, valoare;

		while (scanner.hasNext()) {
			valoare = scanner.nextInt();
			i = i + 1;
			suma = suma + valoare;

			if (minim > valoare)
				minim = valoare;
			if (maxim < valoare)
				maxim = valoare;

		}

		System.out.println(suma + "\n" + (float) suma / i + "\n" + minim + "\n" + maxim + "\n");

		PrintStream flux_out = new PrintStream("out.txt");
		flux_out.print(suma + "\n" + (float) suma / i + "\n" + minim + "\n" + maxim + "\n");
		flux_out.close();

	}

}
