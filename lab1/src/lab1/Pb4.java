package lab1;

import java.util.Random;

public class Pb4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Random random = new Random();
		int x, y;

		do {
			x = random.nextInt() % 31;
			y = random.nextInt() % 31;
		} while (x < 1 || y < 1);

//		x = x % 31;
	//	y = y % 31;

		System.out.print("Divizorul comun al " + x + " " + y + " este ");

		while (x != y) {
			if (x > y)
				x = x - y;
			else
				y = y - x;
		}

		System.out.println(x);

	}
}
