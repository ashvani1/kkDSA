//Length of longest Palindromic substring
public class Qn14 {
        public int longestPalindromeSubstrLength(String s) {
            int n = s.length();

            // Create a 2D DP array to store if substrings are palindromic
            boolean[][] dp = new boolean[n][n];
            int maxLength = 1; // Variable to store the length of the longest palindromic substring

            // All substrings of length 1 are palindromic
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            // Check substrings of length 2
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    maxLength = 2;
                }
            }

            // Check substrings of length 3 and more
            for (int len = 3; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        maxLength = len;
                    }
                }
            }

            return maxLength;
        }
    }
/*
The variable maxLength is introduced to keep track of the length of the longest palindromic substring encountered so far.
The code updates maxLength whenever it discovers a longer palindromic substring.
This solution has a time complexity of O(n^2) and a space complexity of O(n^2), similar to the previous solution. It utilizes dynamic programming to efficiently find the length of the longest palindromic substring. */