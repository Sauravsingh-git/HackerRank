import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {

        int n = s.length();
        int row = (int)Math.ceil(Math.sqrt(n));
        int col = (int)Math.ceil(Math.sqrt(n));
        String result = "";
        for ( int i = 0; i < row; i++){
            int j = 0;
            while(i+j < n){
                result = result + s.substring(i+j,i+j+1);
                j = (int) j + col;
            }
            result = result + " ";
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
