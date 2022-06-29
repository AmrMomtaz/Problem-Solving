package webalo;

import round_181.Array;

import java.util.HashSet;

public class Graph {
    private int x;

    class y{
        void foo(){
            System.out.println(x);
        }
    }
    public static int ArrayChallenge(int[] arr) {
        int count = 0;
        int end =0;
        int farthest = 0;
        for (int i = 0 ; i < arr.length - 1 ; i++){
            farthest = Math.max(farthest,i+arr[i]);
            if (i==end){
                count++;
                end = farthest;
            }
        }
        if (farthest < arr.length-1)
            return -1;
        else
            return count;
    }

}
