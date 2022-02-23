package brimore;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Hashtable;

public class Contest_Day {

    static class FenwickTree{

        public static BigInteger getSum(int index,BigInteger[] BITree){
            BigInteger sum = BigInteger.ZERO;
            index++;
            while(index>0) {
                sum = sum.add(BITree[index]);
                index -= index & (-index);
            }
            return sum;
        }

        public static void updateBIT(int index,long val,BigInteger[] BITree){
            BigInteger bigVal = BigInteger.valueOf(val).
                    subtract(getSum(index, BITree).subtract(getSum(index-1, BITree)));
            index++;
            while(index < BITree.length) {
                BITree[index] = BITree[index].add(bigVal);
                index += index & (-index);
            }
        }

        public static void updateBITConstruction(int index,long val,BigInteger[] BITree){
            index++;
            while(index < BITree.length){
                BITree[index] = BITree[index].add(BigInteger.valueOf(val));
                index += index & (-index);
            }
        }

        public static BigInteger[] constructBITree(long[] arr){
            BigInteger[] BITree = new BigInteger[arr.length+1];
            Arrays.fill(BITree, BigInteger.ZERO);
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
        long[] arr = new long[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(input[i]);
        Hashtable<Integer, BigInteger[]> hashtable = new Hashtable<>();
        hashtable.put(1,FenwickTree.constructBITree(arr));
        int index = 2;
        for(int i = 0 ; i < Q ; i++){
            input = br.readLine().split(" ");
            int OP = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            BigInteger[] BITree = hashtable.get(k);
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
                        bw.write((FenwickTree.getSum(e, BITree).subtract(FenwickTree.getSum(s-1, BITree))) + "\n");
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