package net.guhya.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coin {
    
    static int count = 0;
    static List<List<Integer>> coinsUsed;
    
    private static int ways(int[] coins, int target) {
        count = 0;
        int ways = waysHelper(coins, coins.length-1, target);
        System.out.print(count + " -> ");
        return ways;
    }
    
    private static int waysMemo(int[] coins, int target) {
        count = 0;
        Map<String, Integer> memo = new HashMap<>();
        int ways = waysMemoHelper(coins, coins.length-1, target, memo);
        System.out.print(count + " -> ");
        return ways;
    }

    private static int ways(int[] coins, int target, List<Integer> used) {
        count = 0;
        coinsUsed = new ArrayList<>();
        int ways = waysHelper(coins, coins.length-1, target, used);
        System.out.print(coinsUsed + " " + count + " -> ");
        return ways;
    }

    private static int waysHelper(int[] coins, int hi, int sum) {
        count++;
        if (hi < 0) return 0;        
        if (sum < 0) return 0;
        if (sum == 0) return 1;
        
        int include = waysHelper(coins, hi, sum-coins[hi]);
        int exclude = waysHelper(coins, hi-1, sum);
        
        int found = include + exclude;
        
        return found;
    }

    private static int waysMemoHelper(int[] coins, int hi, int sum, Map<String, Integer> memo) {
        count++;
        if (hi < 0) return 0;
        
        if (sum < 0) return 0;
        if (sum == 0) return 1;
        if (memo.containsKey(sum+":"+hi)) {
            return memo.get(sum+":"+hi);
        }
        
        int include = waysMemoHelper(coins, hi, sum-coins[hi], memo);
        int exclude = waysMemoHelper(coins, hi-1, sum, memo);
        
        int found = include + exclude;
        if (found > 0) memo.put(sum+":"+hi, found);
        
        return found;
    }
    
    private static int waysHelper(int[] coins, int hi, int sum, List<Integer> usedList) {
        count++;
        if (hi < 0) return 0;
        if (sum < 0) return 0;
        if (sum == 0) {
            coinsUsed.add(usedList);
            return 1;
        }
        
        int exclude = waysHelper(coins, hi-1, sum, new ArrayList<Integer>(usedList));
        usedList.add(coins[hi]);
        int include = waysHelper(coins, hi, sum-coins[hi], new ArrayList<Integer>(usedList));        
        
        int found = include + exclude;
        return found;
    }
    

    public static void main(String[] args) {
        int[] coins1 = {12, 31, 40, 50};
        int target1 = 1000;
        System.out.println(ways(coins1, target1));
        System.out.println(waysMemo(coins1, target1));
        System.out.println(ways(coins1, target1, new ArrayList<Integer>()));
        System.out.println("+++++++++++");
        
    }

}
