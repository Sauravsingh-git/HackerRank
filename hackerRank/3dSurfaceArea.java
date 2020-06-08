import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] arr) {

        int top, bottom, left, right, up, down;
        int curr;
        int surfaceArea  = 0;
        for ( int i = 0; i < arr.length; i++){
            
            for ( int j = 0; j < arr[0].length; j++){
                top = bottom = left = right = up = down = 0;
                curr = arr[i][j];
                
                if (arr[i][j] != 0){
                top++;
                bottom++;
                }
                //up
                if ( i + 1 < arr.length){
                    if(curr > arr[i + 1][j])
                    up = curr - arr[i + 1][j];
                }
                else{
                    up = curr;
                }
                //down
                if ( i - 1 >= 0){
                    if(curr > arr[i - 1][j])
                    down = curr - arr[i - 1][j];
                }
                else{
                    down = curr;
                }
                //right
                if ( j + 1 < arr[0].length){
                    if(curr > arr[i][j + 1])
                    right = curr - arr[i][j + 1];
                }
                else{
                    right = curr;
                }
                //left
                if ( j - 1 >= 0){
                    if(curr > arr[i][j - 1])
                    left = curr - arr[i][j - 1];
                }
                else{
                    left = curr;
                }
                
                surfaceArea += top + bottom + left + right + up + down;
            }
            
        }

        return surfaceArea;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
