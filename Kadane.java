import java.util.Scanner;

/*Kadane's algorithm
 * used to find out the maximum sum of a sub array in an array
 * time complexity of the algorithm : O(n)*/
public class Kadane {
	private static Scanner sc = new Scanner(System.in);

	static int maxSubarray(int[] ar) {
		int maxSum = ar[0];
		int sum = maxSum;
		
		for (int i = 1; i < ar.length; i++) {
			sum = Math.max(sum + ar[i], ar[i]);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;

	}

	public static void main(String[] args) {
		System.out.println("Enter the no. of elements in array : ");
		int n = sc.nextInt();
		int [] ar = new int [n];
		for(int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		
		System.out.println("The sum of maximum subarray is : " + maxSubarray(ar));
	}

}
