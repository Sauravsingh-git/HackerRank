package hackerRank;

import java.util.Scanner;

public class QueenAttack2 {
	private static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q_row = sc.nextInt();
		int q_col = sc.nextInt();
		
		int top = n - q_row;
		int bottom = q_row - 1;
		int left = q_col - 1;
		int right = n - q_col;
		int tleft = Math.min(top, left);
		int bleft = Math.min(bottom, left);
		int tright = Math.min(top, right);
		int bright = Math.min(bottom, right);
		
		
		for ( int i = 0; i < k; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			if ( row == q_row) {
				if ( col < q_col)
					left = Math.min(left, q_col - col - 1);
				else 
					right = Math.min(right,  col - q_col - 1);
			}
			else if ( col == q_col) {
				if (row < q_row)
					bottom = Math.min(bottom, q_row - row - 1);
				else
					top = Math.min(top,	row - q_row - 1);
			}
			
			else if (Math.abs(row - q_row) == Math.abs(col - q_col)) {
				
				int diff = Math.abs(col - q_col) - 1;
				if(col > q_col) {
					
					if (row > q_row) 
						tright = Math.min(tright, diff);
					else
						bright = Math.min(bright, diff);
					
				}else {
					
					
					if (row > q_row) 
						tleft = Math.min(tleft, diff);
					else
						bleft = Math.min(bleft, diff);
					
				}
			}
		}
		
		int result = top + bottom + left + right + tleft + tright + bleft + bright;
		System.out.println(result);
		

	}

}
