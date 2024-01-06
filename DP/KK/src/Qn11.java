//https://docs.google.com/document/d/1yykv6-Ox3lxOhWIdDi9lrSeWK7wpbI9avVQbCFkVTE4/edit
import java.util.Scanner;
public class Qn11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        long[][] dp = new long[100005][2];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextLong();
        }

        dp[1][0] = a[1];
        dp[1][1] = b[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + a[i], dp[i - 2][1] + a[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + b[i], dp[i - 2][0] + b[i]);
        }

        System.out.println(dp[n][0] + " " + dp[n][1]);
    }
}
