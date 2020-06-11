import java.util.Arrays;
import java.util.Scanner;

public class Solutions {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String[] rcn = sc.nextLine().split(" ");

		int r = Integer.parseInt(rcn[0]);
		int c = Integer.parseInt(rcn[1]);
		int n = Integer.parseInt(rcn[2]);

		String[] ar = new String[r];

		for (int i = 0; i < r; i++) {
			ar[i] = sc.nextLine();
		}

		char[][] result = bomberMan(ar, n, r, c);

		for (char[] t : result) {
			for (char p : t)
				System.out.print(p);
			System.out.println();
		}

	}

	private static char[][] bomberMan(String[] ar, int n, int r, int c) {
		char[][] a = new char[ar.length][];
		for (int i = 0; i < ar.length; i++) {
			a[i] = ar[i].toCharArray();
		}

		if (n <= 1)
			return a;
		if (n % 2 == 0)
			return fullBombField(r, c);
		if (n % 4 == 3)
			return mod3(a);
		if (n % 4 == 1)
			return mod5(a);

		return null;
	}

	static char[][] fullBombField(int r, int c) {
		char[][] result = new char[r][c];
		for (char[] t : result)
			Arrays.fill(t, 'O');

		return result;

	}

	static char[][] mod3(char[][] ar) {
		char[][] result = new char[ar.length][ar[0].length];
		for (char[] c : result)
			Arrays.fill(c, 'O');
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				if (ar[i][j] == 'O' || deadByNeighbour(ar, i, j))
					result[i][j] = '.';
			}
		}
		return result;
	}

	static boolean deadByNeighbour(char[][] ar, int i, int j) {

		if (i - 1 >= 0 && ar[i - 1][j] == 'O')
			return true;
		if (j - 1 >= 0 && ar[i][j - 1] == 'O')
			return true;
		if (i + 1 < ar.length && ar[i + 1][j] == 'O')
			return true;
		if (j + 1 < ar[0].length && ar[i][j + 1] == 'O')
			return true;
		return false;
	}

	static char[][] mod5(char[][] ar) {
		char[][] r1 = mod3(ar);
		char[][] result = mod3(r1);
		return result;
	}

}
