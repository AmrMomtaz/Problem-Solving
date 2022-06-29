package others;

public class LongestDominoSequence {

    public static int longestDominoSequence(String[] input){
        int max = 1;
        int currentMax = 1;
        for (int i = 1 ; i < input.length ; i++){
            if (input[i].charAt(0) == input[i-1].charAt(2))
                currentMax++;
            else {
                max = Math.max(currentMax, max);
                currentMax = 1;
            }
        }
        max = Math.max(currentMax, max);
        return max;
    }
    public static void main(String[] args){
        String[] strings = new String[]{"1,3", "3,2", "2,1", "5,6", "6,2"};
        System.out.println(longestDominoSequence(strings));
    }
}
