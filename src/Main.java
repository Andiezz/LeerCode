import java.sql.Array;
import java.util.Arrays;

public class Main {
//    public static int rec(int[] coins, int remain) {
//        if(remain < 0) return -1;
//        if(remain == 0) return 0;
//
//        if(mem[remain] != -1) {
//            return mem[remain];
//        }
//
//        int minCount = Integer.MAX_VALUE;
//        for(int coin: coins) {
//            int count = rec(coins, remain - coin);
//            if (count == -1) continue;
//            minCount = Math.min(minCount, count + 1);
//        }
//        mem[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
//        return mem[remain];
//    }
//
//    public static int coinChange(int[] coins, int amount) {
//        mem = new int[amount + 1];
//        Arrays.fill(mem, -1);
//        mem[0] = 0;
//        return rec(coins, amount);
//    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin: coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        System.out.println(coinChange(coins, 6249));
    }
}