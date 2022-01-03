package lab1;

import java.util.Random;

public class Pb5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();

		int x;

		do {
			x = random.nextInt() % 21;
		} while (x < 0);

		int a = 0, b = 1, c = 0;

		while (c < x) {
			c = a + b;
			a = b;
			b = c;
		}

		if (c == x)
			System.out.println(x + " este un numar din sirul lui Fibonnaci\n");
		else
			System.out.println(x + " nu este un numar din sirul lui Fibonnaci\n");
	}

}
