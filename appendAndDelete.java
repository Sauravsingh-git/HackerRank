 import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static String appendAndDelete(String s, String t, int k) {

        int l = Math.min(s.length(), t.length());
        
        int i = 0;
        while (i < l  && s.charAt(i) == t.charAt(i)){
            i++;
        }

        int totaloperations = s.length() - i + t.length() - i ;
        if(totaloperations <= k && ((k - totaloperations) % 2 == 0|| s.length() + t.length() <= k))
        return "Yes";
        else
        return "No";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
