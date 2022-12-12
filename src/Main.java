public class Main {
    public int rec(int[] coins, int remain) {
        if(remain < 0) return -1;
        if(remain == 0) return 0;

        int minCount = Integer.MAX_VALUE;
        for(int coin: coins) {
            int count = rec(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    public int coinChange(int[] coins, int amount) {
        return rec(coins, amount);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}