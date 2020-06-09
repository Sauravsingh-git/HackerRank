import java.util.Scanner;

public class Solution {
	
	public static int  FirstDuplicate (int [] n) {
		int i;
		for ( i = 0; i < n.length; i++) {
			if ( n[Math.abs(n[i]) - 1] < 0) {
				return n[i];
			}
			else {
				n[Math.abs(n[i] - 1)] =  - n[Math.abs(n[i] - 1)];
				
			}
		}
		return n[i];	
	}

	private static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int  [] array = new int [n];
		for ( int i = 0; i < n; i++)
		array[i] = sc.nextInt();
		
		System.out.println(FirstDuplicate(array));
	}
}
