package google_practice_kickstart_2022;

import java.util.PriorityQueue;
import java.util.Scanner;

public class H_Index {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0 ; t < T ; t++){
            int N = sc.nextInt();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            int score = 0;
            System.out.print("Case #"+(t+1)+": ");
            for(int i = 0 ; i < N ; i++){
                int number = sc.nextInt();
                if(i==0){
                    priorityQueue.add(number);
                    System.out.print("1 ");
                }else{
                    if(number> priorityQueue.peek()){
                        priorityQueue.add(number);
                        if(priorityQueue.peek()==score)
                            priorityQueue.poll();
                    }else if (number>score)
                        priorityQueue.add(number);
                    score = Math.min(priorityQueue.peek(), priorityQueue.size());
                    System.out.print(score + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
