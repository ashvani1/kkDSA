//https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
public class Qn15 {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();

            // Create a 2D DP array to store the length of the LPS for substrings
            int[][] dp = new int[n][n];

            // All substrings of length 1 have an LPS of length 1
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            // Check substrings of length 2 and more
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[0][n - 1];
        }
    }

    /*
 The dp array is a 2D array where dp[i][j] represents the length of the Longest Palindromic Subsequence for the substring from index i to j.

The base case is that all substrings of length 1 have an LPS of length 1.

The code iterates over substrings of length 2 and more, updating the dp array based on whether the characters at the ends of the substring are the same or not.

The final result is stored in dp[0][n - 1], which represents the length of the Longest Palindromic Subsequence for the entire string.

This solution has a time complexity of O(n^2) and a space complexity of O(n^2), where n is the length of the input string.*/