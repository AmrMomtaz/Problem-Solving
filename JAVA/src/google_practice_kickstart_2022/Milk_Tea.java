package google_practice_kickstart_2022;

import java.util.HashSet;
import java.util.Scanner;

public class Milk_Tea {

    private static String findInitialSolution(int[] count,int N){
        StringBuilder result = new StringBuilder(100);
        for(int i = 0 ; i < count.length ; i++){
            if((double)count[i] >= (double)N/2)
                result.append("1");
            else
                result.append("0");
        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0 ; t < T ; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int P = sc.nextInt();
            String[] customers = new String[N];
            for (int i = 0 ; i < N ; i++)
                customers[i] = sc.next();
            HashSet<String> forbidden = new HashSet(M);
            for (int i = 0 ; i < M ; i++)
                forbidden.add(sc.next());
            int[] count = new int[P];
            for(int i = 0 ; i < N ; i++) {
                for (int j = 0; j < P; j++) {
                    if (customers[i].charAt(j) == '1') {
                        count[j]++;
                    }
                }
            }
            String initialSolution = findInitialSolution(count,N);
            if (forbidden.contains(initialSolution))
                System.out.println("NULL");
            else
                System.out.println(initialSolution);
        }
        sc.close();
    }
}
