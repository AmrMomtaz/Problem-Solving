package google_practice_kickstart_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Milk_Tea {

    private static HashSet<String> forbidden;
    private static String[] customers;
    private static int[] count;
    private static int[] conflicts;
    private static String bestOrder;

    private static void initializeConflicts(){
        StringBuilder order = new StringBuilder(100);
        conflicts = new int[count.length];
        for(int i = 0 ; i < conflicts.length ; i++) {
            if((double)count[i]>=(double)customers.length/2){
                order.append("1");
                conflicts[i] = customers.length - count[i];
            }else{
                order.append("0");
                conflicts[i] = count[i];
            }
        }
        bestOrder = order.toString();
    }

    private static int getScore(int relaxations){
        int sum = 0;
        int[] relaxingConflicts = conflicts.clone();
        Arrays.sort(relaxingConflicts);
        for(int i = relaxingConflicts.length-1;i >=0 ; i--){
            if(relaxations>0){
                sum+=customers.length-relaxingConflicts[i];
                relaxations--;
            }else
                sum+=relaxingConflicts[i];
        }
        return sum;
    }

    private static LinkedList<String> getPossibleMatches(int relaxations){

        return null;
    }

    private static boolean checkValidity(LinkedList<String> order){
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0 ; t < T ; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int P = sc.nextInt();
            customers = new String[N];
            for (int i = 0 ; i < N ; i++)
                customers[i] = sc.next();
            forbidden = new HashSet(M);
            for (int i = 0 ; i < M ; i++)
                forbidden.add(sc.next());
            count = new int[P];
            for(int i = 0 ; i < N ; i++) {
                for (int j = 0; j < P; j++) {
                    if (customers[i].charAt(j) == '1') {
                        count[j]++;
                    }
                }
            }
            initializeConflicts();
            int relaxations = 0;
            while(true){
                int cost = getScore(relaxations);
                LinkedList<String> possibleMatches = getPossibleMatches(relaxations);
                boolean check = checkValidity(possibleMatches);
                if(check) {
                    System.out.println(cost);
                    sc.close();
                    return;
                }
                relaxations++;
            }
        }
    }
}
