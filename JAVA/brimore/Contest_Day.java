package brimore;

import java.io.*;

import java.util.Hashtable;

public class Contest_Day {

    private static Hashtable<Integer,Integer> resolveFrom = new Hashtable<>();
    private static Hashtable<Integer, Hashtable<Integer,Long>> listOfArrays = new Hashtable<>();

    static class FenwickTree{

        public static long getSum(int index,Hashtable<Integer,Long> BITree,int k){
            long sum = 0;
            index++;
            while(index>0) {
                if(BITree.containsKey(index))
                    sum +=BITree.get(index);
                else{
                    int nextK = resolveFrom.get(k);
                    Hashtable<Integer,Long> nextTree = listOfArrays.get(nextK);
                    while(!nextTree.containsKey(index)){
                        nextK = resolveFrom.get(nextK);
                        nextTree = listOfArrays.get(nextK);
                    }
                    sum +=nextTree.get(index);
                }
                index -= index & (-index);
            }
            return sum;
        }

        public static void updateBIT(int index,long val,Hashtable<Integer,Long> BITree,int k){
            val -= getSum(index, BITree,k) - getSum(index-1, BITree,k);
            index++;
            while(index < BITree.size()) {
                BITree.put(index,BITree.getOrDefault(index,0l) + val);
                index += index & (-index);
            }
        }

        public static void updateBITConstruction(int index,long val,Hashtable<Integer,Long> BITree){
            index++;
            while(index < BITree.size()){
                BITree.put(index,BITree.get(index) + val);
                index += index & (-index);
            }
        }

        public static Hashtable<Integer,Long> constructBITree(int[] arr){
            Hashtable<Integer,Long> BITree = new Hashtable<>(arr.length+1);
            for(int i = 0 ; i < arr.length+1 ; i++)
                BITree.put(i,0l);
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
        listOfArrays.put(1,FenwickTree.constructBITree(arr));
        int index = 2;
        for(int i = 0 ; i < Q ; i++){
            input = br.readLine().split(" ");
            int OP = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            Hashtable<Integer,Long> BITree = listOfArrays.get(k);
            switch (OP) {
                case 1:
                    int A = Integer.parseInt(input[2])-1;
                    int B = Integer.parseInt(input[3]);
                    FenwickTree.updateBIT(A, B, BITree,k);
                    break;
                case 2:
                    int s = Integer.parseInt(input[2])-1;
                    int e = Integer.parseInt(input[3])-1;
                    if (s == 0)
                        bw.write(FenwickTree.getSum(e, BITree,k) + "\n");
                    else
                        bw.write((FenwickTree.getSum(e, BITree,k)-FenwickTree.getSum(s-1, BITree,k)) + "\n");
                    break;
                case 3:
                    listOfArrays.put(index, new Hashtable<>());
                    resolveFrom.put(index,k);
                    index++;
                    break;
            }
        }
        br.close();
        bw.close();
    }
}