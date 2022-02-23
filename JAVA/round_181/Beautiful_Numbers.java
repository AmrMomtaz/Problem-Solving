package round_181;

import java.math.BigInteger;
import java.util.Scanner;

public class Beautiful_Numbers {
    private static BigInteger[] factorials;
    private static BigInteger mod;

    private static BigInteger modularExponentiation(BigInteger x){
        BigInteger res = BigInteger.ONE;
        long y = 1000000005;
        if (x == BigInteger.ZERO)
            return BigInteger.ZERO;
        while (y > 0){
            if ((y & 1) != 0) {
                res = res.multiply(x);
                res = res.mod(mod);
            }
            y = y >> 1;
            x = x.multiply(x);
            x = x.mod(mod);
        }
        return res;
    }
    private static BigInteger calculateCombination(int n, int r){
        BigInteger nFact = factorials[n];
        BigInteger nrFact = modularExponentiation(factorials[n-r]);
        BigInteger rFact = modularExponentiation(factorials[r]);
        BigInteger result = nFact.multiply(nrFact);
        result = result.mod(mod);
        result = result.multiply(rFact);
        result = result.mod(mod);
        return result;
    }
    private static boolean isExcellent(int number,int a,int b){
        char[] chars = Integer.toString(number).toCharArray();
        char ch1 = (char)(a+48);
        char ch2 = (char)(b+48);
        for(char ch :chars)
            if(ch!=ch1 && ch!=ch2)
                return false;
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        mod = BigInteger.valueOf(1000000007);
        factorials = new BigInteger[n+1];
        factorials[0]=BigInteger.ONE;
        for(int i = 1 ; i <= n ; i++) {
            factorials[i] = factorials[i-1].multiply(BigInteger.valueOf(i));
            factorials[i] = factorials[i].mod(mod);
        }
        int sum = a*n;
        int diff = b-a;
        BigInteger result = BigInteger.ZERO;
        for(int i = 0 ; i <= n ; i++){
            if(isExcellent(sum,a,b)) {
                result = result.add(calculateCombination(n, i));
                result = result.mod(mod);
            }
            sum+=diff;
        }
        System.out.println(result);
    }
}
