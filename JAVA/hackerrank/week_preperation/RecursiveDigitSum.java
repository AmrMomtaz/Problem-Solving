package hackerrank.week_preperation;

import java.io.*;

public class RecursiveDigitSum {
    static class Result {
        /*
         * Complete the 'superDigit' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING n
         *  2. INTEGER k
         */

        private static int getSuperDigit(String n){
            if(n.length()<=1)
                return Integer.parseInt(n);
            else{
                int mid = n.length()/2;
                String left = n.substring(0,mid);
                String right = n.substring(mid);
                return getSuperDigit(((getSuperDigit(left) + getSuperDigit(right))+""));
            }
        }
        public static int superDigit(String n, int k) {
            int result = getSuperDigit(n);
            result *= k;
            return getSuperDigit(result+"");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
