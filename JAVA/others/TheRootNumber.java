package others;

public class TheRootNumber {

    public static int getRootNumber(String n1, int k1) {
        int result1 = getRoot(Integer.parseInt(n1));
        return (getRoot(result1*k1));
    }

    private static int getRoot(int num){
        if (num < 10)
            return num;
        else{
            String numText = num+"";
            int sum = 0;
            for (int i = 0 ; i < numText.length() ; i++){
                sum += Integer.parseInt("" + numText.charAt(i));
            }
            return getRoot(sum);
        }
    }
}
