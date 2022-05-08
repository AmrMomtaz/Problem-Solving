package hackerrank.week_preperation;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>(); //Always empty stack for enqueuing
        Stack<Integer> stack2 = new Stack<>(); //Stack containing all the data as queue
        int queries = sc.nextInt();
        for (int i = 0 ; i < queries ; i++){
            int query = sc.nextInt();
            switch (query){
                case 1:
                    stack1.push(sc.nextInt());
                    while(!stack2.empty())
                        stack1.push(stack2.pop());

                    break;
                case 2 :
                    break;
                case 3 :
                    break;
                default:
                    System.exit(-1);
            }
        }
        sc.close();
    }
}
