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
        long[] results = new long[N-1];
        long[] sums = new long[N];
        int indexLeft = 0;
        int indexRight = N-1;
        int index = 1;
        results[0] = numbers[N-1]-numbers[0];
        sums[0] = numbers[0];
        sums[N-1] = numbers[N-1];
        boolean lefTurn = true;
        while(index<N-1){
            if(lefTurn){
                results[index] = sums[indexRight] - sums[indexLeft] + results[index-1];
                sums[++indexLeft] = sums[indexLeft-1] + numbers[indexLeft];
                lefTurn= false;
            }else{
                results[index] = sums[indexRight] - sums[indexLeft] + numbers[indexRight-1] +results[index-1];
                sums[--indexRight] = sums[indexRight+1] + numbers[indexRight];
                lefTurn = true;
            }
            index++;
        }
        for(long result : results)
            System.out.print(result + " ");
    }
}
