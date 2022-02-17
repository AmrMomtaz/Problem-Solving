package google_practice_kickstart_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

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

    private static class Word{
        String word;
        int relaxations;

        public Word(String word, int relaxations) {
            this.word = word;
            this.relaxations = relaxations;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    ", relaxations=" + relaxations +
                    '}';
        }
    }

    private static Word getPossibleMatches(int relaxations){
        if(relaxations > 0) {
            StringBuilder result = new StringBuilder(100);
            int[] conflictsSorted = conflicts.clone();
            Arrays.sort(conflictsSorted);
            int modify = conflictsSorted[conflictsSorted.length-relaxations];
            for(int i = 0 ; i < conflicts.length ; i++){
                if(conflicts[i] < modify){
                    result.append(bestOrder.charAt(i));
                }else if (conflicts[i] > modify){
                    char ch = bestOrder.charAt(i)=='0' ? '1':'0';
                    result.append(ch);
                    relaxations--;
                }else
                    result.append("x");
            }
            return new Word(result.toString(),relaxations);
        }else return new Word(bestOrder,0);
    }
    private static int countX(String word){
        int sum = 0;
        for(int i = 0 ; i < word.length() ; i++)
            if(word.charAt(i)=='x')
                sum++;
        return sum;
    }
    private static boolean checkValidity(Word order){
        Stack<Word> stack = new Stack<>();
        stack.push(order);
        while(!stack.isEmpty()){
            Word currentWord = stack.pop();
            //Optimization
            int count = countX(currentWord.word);
            if(count<currentWord.relaxations)
                continue;
            else if(count == currentWord.relaxations){
                StringBuilder currentOrder = new StringBuilder(100);
                for(int i = 0 ; i < currentWord.word.length() ; i++){
                    if(currentWord.word.charAt(i)=='x') {
                        char ch = bestOrder.charAt(i)=='0' ? '1':'0';
                        currentOrder.append(ch);
                    }
                    else {
                        currentOrder.append(currentWord.word.charAt(i));
                    }
                }
                if(forbidden.contains(currentOrder.toString()))
                    continue;
                else
                    return true;
            }
            if(currentWord.relaxations == 0){
                StringBuilder currentOrder = new StringBuilder(100);
                for(int i = 0 ; i < currentWord.word.length() ; i++){
                    if(currentWord.word.charAt(i)=='x')
                        currentOrder.append(bestOrder.charAt(i));
                    else
                        currentOrder.append(currentWord.word.charAt(i));
                }
                if(!forbidden.contains(currentOrder.toString()))
                    return true;
            }else{
                String currentOrder = currentWord.word;
                for(int i = 0 ; i < currentOrder.length() ; i++){
                    if(currentOrder.charAt(i)=='x'){
                        StringBuilder newOrder = new StringBuilder(100);
                        for(int j = 0 ; j < currentOrder.length() ; j++){
                            if(i == j){
                                char ch = bestOrder.charAt(i)=='0' ? '1':'0';
                                newOrder.append(ch);
                            }else{
                                newOrder.append(currentOrder.charAt(j));
                            }
                        }
                        stack.push(new Word(newOrder.toString(),currentWord.relaxations-1));
                    }
                }
            }
        }
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
            forbidden = new HashSet<>(M);
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
                Word possibleMatches = getPossibleMatches(relaxations);
                boolean valid = checkValidity(possibleMatches);
                if(valid) {
                    System.out.println("Case #" + (t+1) + ": " + cost);
                    break;
                }
                relaxations++;
            }
        }
        sc.close();
    }
}