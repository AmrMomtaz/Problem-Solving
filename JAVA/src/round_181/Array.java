package round_181;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0 ; i < N ; i++)
            numbers[i] = sc.nextInt();
        sc.close();
        LinkedList<Integer> set1 = new LinkedList<>();
        LinkedList<Integer> set2 = new LinkedList<>();
        LinkedList<Integer> set3 = new LinkedList<>();
        Arrays.sort(numbers);
        int lastElement = numbers[N-1];
        set1.add(numbers[0]);
        if(lastElement>0){
            set2.add(lastElement);
            for(int i = 1 ; i < N-1 ; i++)
                set3.add(numbers[i]);
        }else{
            set2.add(numbers[1]);
            set2.add(numbers[2]);
            for(int i = 3 ; i < N ; i++)
                set3.add(numbers[i]);
        }
        System.out.print(set1.size()+" ");
        for(Integer n : set1)
            System.out.print(n+" ");
        System.out.println();
        System.out.print(set2.size()+" ");
        for(Integer n : set2)
            System.out.print(n+" ");
        System.out.println();
        System.out.print(set3.size()+" ");
        for(Integer n : set3)
            System.out.print(n+" ");
    }
}
