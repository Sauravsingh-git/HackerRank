import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        char[][] ar = new char[grid.length][];
        char [][] ar1 = new char [grid.length][grid[0].length()];
        for(char[] c : ar1){
            Arrays.fill(c, 1);
        }

        char [][] ar2 = new char [grid.length][grid[0].length()];
        for(char[] c : ar2){
            Arrays.fill(c, 1);
        }

        for ( int i = 0; i < grid.length; i++)
        ar[i] = grid[i].toString();
        // if n is less than or equal to 1, same array will be returned
        if(n >= 1)
        for (int i = 0; i < ar.length; i++)
        for(int j = 0; j < ar[0].length; j++)
        System.out.print(ar[i][j]);

        //the field will always be covered with bombs for every multiple of 2

        if(n % 2 == 0)
        for (int i = 0; i < ar.length; i++)
        for(int j = 0; j < ar[0].length; j++)
        System.out.print(0);



        //first pattern
        for(int i = 0; i < ar.length; i++){
            for (int j = 0; j < ar[0].length; j++){
                if(ar[i][j] == 0){
                    ar1[i][j] = 0;
                    if(i > 0)
                    ar1[i - 1][j] = 0;
                    if(i < ar.length - 1)
                    ar1[i+1][j] = 0;
                    if(j > 0)
                    ar1[i][j - 1] = 0;
                    if(j < ar.length - 1)
                    ar1[i][j+1] = 0;
                }
            }
        }

        if(n%4 == 30){
            for ( int i = 0; i < ar.length; i++){
                for ( int j = 0; j < ar[0].length; j++){
                    if(ar1[i][j] == '1'){
                        System.out.println(0);
                    }
                    else{
                        System.out.println(.);
                    }
                }
            }
        }

        for()


    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
