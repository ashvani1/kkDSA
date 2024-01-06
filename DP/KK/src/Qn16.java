//https://leetcode.com/problems/burst-balloons/description/
public class Qn16 {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Extend the array with 1 on both ends to simplify boundary cases
        int[] balloons = new int[n + 2];
        balloons[0] = balloons[n + 1] = 1;
        System.arraycopy(nums, 0, balloons, 1, n);

        // Create a 2D DP array to store the maximum coins for subarrays
        int[][] dp = new int[n + 2][n + 2];

        // Iterate over different subarray lengths
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            balloons[left] * balloons[k] * balloons[right] + dp[left][k] + dp[k][right]);
                }
            }
        }

        return dp[0][n + 1];
    }
}

/*Explanation:

We extend the nums array by adding balloons with values 1 on both ends. This simplifies the boundary cases when considering subarrays.

The dp array is a 2D array where dp[left][right] represents the maximum coins that can be obtained from bursting balloons in the subarray from index left to right.

We iterate over different subarray lengths (len) and calculate the maximum coins that can be obtained for each subarray. The maximum is calculated by considering each balloon as the last one to be burst in the subarray.

The final result is stored in dp[0][n + 1], which represents the maximum coins for the entire array.

This solution has a time complexity of O(n^3) and a space complexity of O(n^2), where n is the length of the input array nums.*/
