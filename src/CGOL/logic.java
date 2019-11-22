package CGOL;

public class logic extends Thread {

	//
	int UpwardLeft = 0;
	int Upward = 0;
	int UpwardRight = 0;
	int Right = 0;
	int Left = 0;
	int DownwardLeft = 0;
	int Downward = 0;
	int DownwardRight = 0;

	// We can count the no. of alive cells
	int alive = 0, dead = 1;

	// Array given below
	static int array[][] = { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1 }, { 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0 }, };

	// for storing next generation this array is given below
	int[][] generation = new int[5][5];

	public void run() {
		long start = System.nanoTime();

		int num1, num2;

		for (num1 = 0; num1 < 5; num1++) {
			for (num2 = 0; num2 < 5; num2++) {
				generation[num1][num2] = array[num1][num2];
			}
		}
		// logic for next generation
		for (num1 = 0; num1 < 5; num1++) {
			for (num2 = 0; num2 < 5; num2++) {
				alive = 0;

				// here we are assigning values

				if (num1 - 1 < 0 || num2 - 1 < 0)
					UpwardLeft = 0;
				else
					UpwardLeft = array[num1 - 1][num2 - 1];

				if (num1 - 1 < 0)
					Upward = 0;
				else
					Upward = array[num1 - 1][num2];

				if (num1 - 1 < 0 || num2 + 1 > array.length - 1)
					UpwardRight = 0;
				else
					UpwardRight = array[num1 - 1][num2 + 1];

				if (num2 - 1 < 0)
					Left = 0;
				else
					Left = array[num1][num2 - 1];

				if (num2 + 1 > array.length - 1)
					Right = 0;
				else
					Right = array[num1][num2 + 1];

				if (num1 + 1 > array.length - 1 || num2 - 1 < 0)
					DownwardLeft = 0;
				else
					DownwardLeft = array[num1 + 1][num2 - 1];

				if (num1 + 1 > array.length - 1)
					Downward = 0;
				else
					Downward = array[num1 + 1][num2];

				if (num1 + 1 > array.length - 1 | num2 + 1 > array.length - 1)
					DownwardRight = 0;

				else
					DownwardRight = array[num1 + 1][num2 + 1];

				nextGen(num1, num2); // num1 is row and num2 is column
			}
		}

		System.out.println("\nNext Generation\n");
		for (num1 = 0; num1 < 5; num1++) {
			for (num2 = 0; num2 < 5; num2++) {
				System.out.print(generation[num1][num2] + " ");

			}
			System.out.print("\n");
		}

		long end = System.nanoTime();
		System.out.println("Thread execution time: "+ (end-start) + " ns.");
// original array 
		for (num1 = 0; num1 < 5; num1++) {
			for (num2 = 0; num2 < 5; num2++) {
				array[num1][num2] = generation[num1][num2];
			}
		}
	}

	public static void printOriginal() {
		int num1, num2;
		System.out.println("Real");

		for (num1 = 0; num1 < 5; num1++) {
			for (num2 = 0; num2 < 5; num2++) {
				System.out.print(array[num1][num2] + " ");

			}
			System.out.print("\n");
		}
	}

	public void nextGen(int num1, int num2) {
		// number of alive cells
		if (UpwardLeft == 1) {
			alive++;
		}
		if (Upward == 1) {
			alive++;

		}
		if (UpwardRight == 1) {
			alive++;
		}
		if (Left == 1) {
			alive++;
		}
		if (Right == 1) {
			alive++;
		}
		if (DownwardLeft == 1) {
			alive++;
		}
		if (Downward == 1) {
			alive++;
		}
		if (DownwardRight == 1) {
			alive++;
		}
		// cell will die if there will be less then 2 live neighbour cells
		if (alive < 2)
			generation[num1][num2] = 0;
		// cell die if there will be more than 3 cell live in the neighbour
		else if (alive > 3)
			generation[num1][num2] = 0;

		// cell become alive if there are 3 alive neighbour cells
		else if (alive == 3)
			generation[num1][num2] = 1;
		// otherwise it will remain unchanged
		else
			generation[num1][num2] = array[num1][num2];
	}
}
