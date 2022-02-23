package brimore;

import java.io.*;
import java.util.Arrays;

public class Brimore {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++)
            numbers[i] = Integer.parseInt(line[i]);
        br.close();
        Arrays.sort(numbers);
        int lowest = numbers[0];
        for(int i = 0 ; i < N ; i++)
            numbers[i] -= lowest;
        int indexLeft = 0;
        int indexRight = N-1;
        long result = numbers[N-1]-numbers[0];
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        log.write(result + " ");
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
            log.write(result + " ");
        }
        log.close();
    }
}
