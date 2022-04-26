package google_kick_start.roundB;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PalindromicFactors {
    private static void appendAllPossibilities(String word,Queue<String> allPalindromesStrings,int first,int last){
        StringBuilder newWord = new StringBuilder(word);
        if(first == last){
            for(int i = 0 ; i < 10 ; i ++){
                if(first==0 && i ==0)
                    continue;
                newWord.replace(first,first+1,i+"");
                allPalindromesStrings.add(newWord.toString());
            }
        }else{
            for(int i = 0 ; i < 10 ; i ++){
                if (first==0 && i ==0)
                    continue;
                newWord.replace(first,first+1,i+"");
                newWord.replace(last,last+1,i+"");
                allPalindromesStrings.add(newWord.toString());
            }
        }
    }
    // This function returns all palindromes less than 10^10 sorted ascendingly
    private static List<Long> getAllPalindromes(){
        List<Long> allPalindromes = new LinkedList<>();
        Queue<String> allPalindromesStrings = new LinkedList<>();
        for (int i = 1 ; i <= 10 ; i++)
            allPalindromesStrings.add("x".repeat(i));
        while (!allPalindromesStrings.isEmpty()){
            String word = allPalindromesStrings.remove();
            int first = 0;
            int last = word.length()-1;
            // Add to allPalindromes
            while(word.charAt(first)!='x'){
                first++;
                last--;
                if(first>last)
                    break;
            }
            if(first>last){
                allPalindromes.add(Long.parseLong(word));
                continue;
            }
            //Modifying the missed numbers
            appendAllPossibilities(word,allPalindromesStrings,first,last);
        }
        return allPalindromes;
    }

    private static boolean isPalindrome(long number){
        long reverse = 0;
        for (long i = number; i >0 ; i/=10){
            reverse = reverse * 10 + i%10;
        }
        return (number==reverse);
    }
    public static void main(String[]args) {
        isPalindrome(123456789);
        List<Long> palindromes = getAllPalindromes();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1 ; t <= T ; t++){
            long A = sc.nextLong();
            int result = 0;
            for (Long palindrome : palindromes){
                if(palindrome>A/2)
                    break;
                if (A%palindrome==0)
                    result++;
            }
            if(isPalindrome(A))
                result++;
            System.out.println("Case #" + t + ": " + result);
        }
        sc.close();
    }
}
