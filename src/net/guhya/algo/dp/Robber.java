package net.guhya.algo.dp;

public class Robber {

    static int count = 0;
    static int[] memo;
    
    private static int max(int[] houses) {
        count = 0;
        int max = maxHelper(houses, 0);
        System.out.print(count + " -> ");
        return max;
    }

    private static int maxHelper(int[] houses, int lo) {
        count++;
        if (lo >= houses.length) return 0;
        int included = houses[lo] + maxHelper(houses, lo+2);
        int excluded = maxHelper(houses, lo+1);
        int max = Math.max(included, excluded);
        
        return max;
    }

    private static int maxMemo(int[] houses) {
        count = 0;
        memo = new int[houses.length];
        int max = maxMemoHelper(houses, 0, memo);
        System.out.print(count + " -> ");
        return max;
    }

    private static int maxMemoHelper(int[] houses, int lo, int[] memo) {
        count++;
        if (lo >= houses.length) return 0;
        if (memo[lo] > 0) return memo[lo];
        int included = houses[lo] + maxMemoHelper(houses, lo+2, memo);
        int excluded = maxMemoHelper(houses, lo+1, memo);
        int max = Math.max(included, excluded);
        memo[lo] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] houses1 = {2,9,3,5,6};
        System.out.println(max(houses1));
        System.out.println(maxMemo(houses1));
        System.out.println("++++++++++");
        
        int[] houses2 = {2,3,4,5,6};
        System.out.println(max(houses2));
        System.out.println(maxMemo(houses2));
        System.out.println("++++++++++");
        
        int[] houses3 = {2,3,4,5,6,5,6,8,9,5,4,3,1,2,107};
        System.out.println(max(houses3));
        System.out.println(maxMemo(houses3));
        System.out.println("++++++++++");
    }

}
