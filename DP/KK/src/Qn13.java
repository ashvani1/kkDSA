//https://leetcode.com/problems/longest-palindromic-substring/submissions/
public class Qn13 {
    public String longestPalindrome(String s) {
        int n = s.length();

        // Create a 2D DP array to store if substrings are palindromic
        boolean[][] dp = new boolean[n][n];
        int start = 0; // Start index of the longest palindromic substring
        int maxLength = 1; // Length of the longest palindromic substring

        // All substrings of length 1 are palindromic
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check substrings of length 3 and more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        // Extract the longest palindromic substring
        return s.substring(start, start + maxLength);
    }
}

