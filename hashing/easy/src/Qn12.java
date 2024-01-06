//https://practice.geeksforgeeks.org/problems/longest-sub-array-with-prefixSum-k0809/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.HashMap;
import java.util.Map;

public class Qn12 {
    public static int longestSubArrayLength(int A[], int N, int K) {
        //Complete the function
        return max(A, N, K);
    }

    static int max(int[] arr, int n, int k) {
        //to store the prefix sum as the key and the index as the value. This map is used to keep track of the
        // cumulative sum and its corresponding index.

        Map<Long, Integer> mp = new HashMap<>();
        long prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == k)
                maxLen = Math.max(maxLen, i + 1);

            long rem = prefixSum - k;

            //if remainder present in map that means we got a subaraay between previous value and current values which prefixSum is k
            if (mp.containsKey(rem)) {
                int len = i - mp.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!mp.containsKey(prefixSum))
                mp.put(prefixSum, i);
        }
        return maxLen;
    }
}
