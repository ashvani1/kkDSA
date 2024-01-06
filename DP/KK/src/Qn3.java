import java.util.Scanner;

public class Qn3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            cost[i] = sc.nextInt();
        }

        dp[1] = 0;
        dp[2] = Math.abs(cost[2] - cost[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(Math.abs(cost[i] - cost[i - 1]) + dp[i - 1], Math.abs(cost[i] - cost[i - 3]) + dp[i - 3]);
        }

        System.out.println(dp[n]);
    }
}


//https://www.desiqna.in/15983/amazon-summer-school-sep-2023-minimum-cost-reach-destination
