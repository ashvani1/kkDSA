//https://leetcode.com/problems/palindromic-substrings/submissions/
public class Qn12 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // Create a 2D DP array to store if substrings are palindromic
        boolean[][] dp = new boolean[n][n];

        // All substrings of length 1 are palindromic
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // Check substrings of length 3 and more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

