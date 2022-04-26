package google_kick_start.roundB;

import java.util.Scanner;

public class InfinityArea {
    static double getArea(int radius){
        return Math.PI * Math.pow(radius,2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1 ; t <= T ; t++){
            int R = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            double sum = 0;
            while(R>0){
                sum += getArea(R);
                sum += getArea(R*A);
                R = R*A/B;
            }
            System.out.println("Case #" + t + ": " + sum);
        }
        sc.close();
    }
}
