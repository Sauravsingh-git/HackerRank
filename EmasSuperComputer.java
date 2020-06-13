import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	private static Scanner sc = new Scanner(System.in);

	public static class plus {
		int x, y, length, size;

		plus(int x, int y) {
			this.x = x;
			this.y = y;
			this.length = 0;
			this.size = 1;
		}

		plus(int x, int y, int length, int size) {
			this.x = x;
			this.y = y;
			this.length = length;
			this.size = size;
		}

		void grow() {
			this.length++;
			this.size += 4;
		}

		boolean overlap(plus p2, int r, int c) {
			boolean[][] grid = new boolean[r][c];

			for (int i = this.x - this.length; i <= this.x + this.length; i++) {
				grid[this.y][i] = true;
			}

			for (int i = this.y - this.length; i <= this.y + this.length; i++) {
				grid[i][this.x] = true;
			}

			for (int i = p2.x - p2.length; i <= p2.x + p2.length; i++) {
				if (grid[p2.y][i] == true)
					return true;
			}

			for (int i = p2.y - p2.length; i <= p2.y + p2.length; i++) {
				if (grid[i][p2.x] == true)
					return true;
			}
			return false;
		}

	}

	static void findPlus(int x, int y, int r, int c, String[] grid, ArrayList<plus> list) {

		plus p = new plus(x, y);
		int s = 1;
		while (x - s >= 0 && grid[x-s].charAt(y) != 'B' && y - s >= 0 && grid[x].charAt(y-s) != 'B' && x + s < r
				&& grid[x+s].charAt(y) != 'B' && y + s < c && grid[x].charAt(y+s) != 'B') {

			list.add(p);
			s++;
			p.grow();
		}
		list.add(p);

	}

	public static void main(String[] args) {
		String[] s = sc.nextLine().split(" ");
		int r, c;
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);

		ArrayList<plus> list = new ArrayList<>();

		String[] grid = new String[r];

		for (int i = 0; i < r; i++)
			grid[i] = sc.nextLine();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i].charAt(j) != 'B')
					findPlus(i, j, r, c, grid, list);
			}
		}

		int maxArea = 0;

		for (int i = 0; i < list.size(); i++) {
			plus p1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				plus p2 = list.get(j);
				int area = p1.size * p2.size;

				if (maxArea < area && !p1.overlap(p2, r, c))
					maxArea = area;
			}
		}

		System.out.print(maxArea);

	}

}
