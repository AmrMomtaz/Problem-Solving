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
        int lowest = numbers[0];
        for(int i = 0 ; i < N ; i++)
            numbers[i] -= lowest;
        int indexLeft = 0;
        int indexRight = N-1;
        long result = numbers[N-1]-numbers[0];
        System.out.print(result + " ");
        long sumLeft = numbers[0];
        long sumsRight = numbers[N-1];
        boolean lefTurn = true;
        while(indexLeft<indexRight-1){
            if(lefTurn){
                result+= sumsRight - sumLeft;
                sumLeft+=numbers[++indexLeft];
                lefTurn= false;
            }else{
                result += sumsRight - sumLeft + numbers[indexRight-1];
                sumsRight += numbers[--indexRight];
                lefTurn = true;
            }
            System.out.print(result + " ");
        }
    }
}
