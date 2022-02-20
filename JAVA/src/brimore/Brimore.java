package brimore;

import java.util.Arrays;
import java.util.Scanner;

public class Brimore {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0 ; i < N ; i++)
            numbers[i] = sc.nextInt();
        sc.close();
        Arrays.sort(numbers);
        int[] results = new int[N-1];
        int[] sums = new int[N];
        int indexLeft = 1;
        int indexRight = N-2;
        results[0] = numbers[N-1]-numbers[0];
        sums[0] = numbers[0];
        sums[N-1] = numbers[N-1];
        boolean lefTurn = true;
        while(indexLeft<=indexRight){
            
        }
        for(int result : results)
            System.out.print(result + " ");
    }
}
