import java.util.Scanner;

public class Knapsnack {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the no of objects");
		int n = sc.nextInt();

		System.out.println("Enter the weights");
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
		}

		System.out.println("Enter their profits respectively: ");
		int[] profit = new int[n];

		for (int i = 0; i < n; i++) {
			profit[i] = sc.nextInt();
		}

		System.out.println("Enter the capacity of bag: ");
		int capacity = sc.nextInt();

		maxProfit(weights, profit, capacity);

	}

	private static void maxProfit(int[] weights, int[] profit, int capacity) {
		int[][] grid = new int[weights.length + 1][capacity + 1];

		for (int i = 0; i <= Math.max(capacity, weights.length); i++) {
			if (i <= capacity)
				grid[0][i] = 0;
			if (i <= weights.length)
				grid[i][0] = 0;
		}
		for (int i = 1; i <= weights.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (weights[i - 1] > j  )
					grid[i][j] = grid[i - 1][j];
				else
					grid[i][j] = Math.max(grid[i - 1][j], grid[i - 1][j - weights[i - 1]] + profit[i - 1]);
			}
		}
		for (int[] i : grid) {
			for (int j : i) {
				System.out.print(j + " ");

			}
			System.out.println();
		}
		
		System.out.println("The max profit is : " + grid[weights.length][capacity]);
	}

}
