import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   
    static String appendAndDelete(String given, String desired, int k) {

        if(given.equals(desired))
            return "Yes";

        String checkString = desired;

        boolean isFound = false;
        while(!checkString.isEmpty()){
            if(given.contains( checkString )){
                isFound = true;
                break;
            }else
                checkString = checkString.substring(0, checkString.length()-1);
        }

        int diff=Math.abs(given.length()-checkString.length());
        int diff2=Math.abs(desired.length()-checkString.length());

        if(diff+diff2<=k && ((k -(diff + diff2))%2==0 || given.length()+desired.length()    <=k ))
            return "Yes";
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
