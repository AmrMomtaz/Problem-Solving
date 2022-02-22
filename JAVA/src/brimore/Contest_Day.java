package brimore;

import java.io.*;

public class Contest_Day {
    static class BinaryIndexedTree{

        public static long getSum(int index,long[] BITree){
            long sum = 0;
            index = index + 1;
            while(index>0) {
                sum += BITree[index];
                index -= index & (-index);
            }
            return sum;
        }

        public static void updateBIT(int index,int val,long[] BITree){
            index = index + 1;
            while(index <= BITree.length) {
                BITree[index] += val;
                index += index & (-index);
            }
        }

        public static long[] constructBITree(int arr[]){
            long[] BITree = new long[arr.length+1];
            for(int i = 0; i < arr.length; i++)
                updateBIT(i, arr[i], BITree);
            return BITree;
        }

        // Main function
        public static void main(String args[]){
            int freq[] = {2, 1, 1, 3, 2, 3,
                    4, 5, 6, 7, 8, 9};
            long[] BITree = constructBITree(freq);

            System.out.println("Sum of elements in arr[0..5]"+
                    " is "+ getSum(5,BITree));

            // Let use test the update operation
            freq[3] += 6;

            // Update BIT for above change in arr[]
            updateBIT(3, 6,BITree);

            // Find sum after the value is updated
            System.out.println("Sum of elements in arr[0..5]"+
                    " after update is " + getSum(5,BITree));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int[] arr = new int[N];
        int Q = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        for(int i = 0 ; i < Q ; i++){

        }

        bw.close();
    }
}