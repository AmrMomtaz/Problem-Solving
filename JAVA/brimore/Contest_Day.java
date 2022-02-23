package brimore;

import java.io.*;

import java.util.Hashtable;

public class Contest_Day {

    static class FenwickTree{

        public static long getSum(int index,long[] BITree){
            long sum = 0;
            index++;
            while(index>0) {
                sum +=BITree[index];
                index -= index & (-index);
            }
            return sum;
        }

        public static void updateBIT(int index,long val,long[] BITree){
            val -= getSum(index, BITree) - getSum(index-1, BITree);
            index++;
            while(index < BITree.length) {
                BITree[index] += val;
                index += index & (-index);
            }
        }

        public static void updateBITConstruction(int index,long val,long[] BITree){
            index++;
            while(index < BITree.length){
                BITree[index] += val;
                index += index & (-index);
            }
        }

        public static long[] constructBITree(int[] arr){
            long[] BITree = new long[arr.length+1];
            for(int i = 0; i < arr.length; i++)
                updateBITConstruction(i, arr[i], BITree);
            return BITree;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        Hashtable<Integer, long[]> hashtable = new Hashtable<>();
        hashtable.put(1,FenwickTree.constructBITree(arr));
        int index = 2;
        for(int i = 0 ; i < Q ; i++){
            input = br.readLine().split(" ");
            int OP = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            long[] BITree = hashtable.get(k);
            switch (OP) {
                case 1:
                    int A = Integer.parseInt(input[2])-1;
                    int B = Integer.parseInt(input[3]);
                    FenwickTree.updateBIT(A, B, BITree);
                    break;
                case 2:
                    int s = Integer.parseInt(input[2])-1;
                    int e = Integer.parseInt(input[3])-1;
                    if (s == 0)
                        bw.write(FenwickTree.getSum(e, BITree) + "\n");
                    else
                        bw.write((FenwickTree.getSum(e, BITree)-FenwickTree.getSum(s-1, BITree)) + "\n");
                    break;
                case 3:
                    hashtable.put(index, BITree.clone());
                    index++;
                    break;
            }
        }
        br.close();
        bw.close();
    }
}