package insurance;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int requests = sc.nextInt();
		for (int i = 0; i < requests; i++) {
			// read
			int price = sc.nextInt();
			int carAge = sc.nextInt();
			int driverAge = sc.nextInt();
			int tickets = sc.nextInt();
			int accidents = sc.nextInt();
			// process
			int carValue = (int) (price * Math.pow(.9, carAge));
			carValue = (carValue < 3000) ? 3000 : carValue;
			int ticketMult = factorial(tickets);
			int accidentMult = factorial(accidents);
			double ageMult = (driverAge < 25) ? 3 : (driverAge < 35) ? 1.5
					: (driverAge < 45) ? 1 : (driverAge < 65) ? 1.5 : 3;
			double insuranceValue = carValue * 0.019 * ticketMult
					* accidentMult * ageMult;

			if (driverAge < 16 || accidents > 3 || tickets > 3) {
				System.out.printf("Request %d: The driver is uninsurable.\n",
						i + 1);
			} else {
				System.out.printf("Request %d: $%.2f\n", i + 1, insuranceValue);
			}
		}
		System.out.println("END OF OUTPUT");
	}

	public static int factorial(int in) {
		int value = 1;
		for (int i = in; i > 0; i--) {
			value *= i;
		}
		return value;
	}
}
