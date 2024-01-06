//https://leetcode.com/problems/subarray-sum-equals-k/submissions/1110664394/
//this is different variant of Qn12

import java.util.*;

public class Qn13 {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;

        //to store the cumulative sums and their frequencies. The key is the cumulative sum, and the value is the count
        // of how many times that sum has been encountered.
        Map<Integer, Integer> map = new HashMap<>();
        map.put(prefixSum, 1);
        //as we have to find count, so we are making first entry as 0 is coming 1 time

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            Integer rem = prefixSum - k;
            if (map.containsKey(rem)) {
                answer += map.get(rem);
            }

            //If the sum is already in the map, increment its count; otherwise, add a new entry with a count of 1.
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return answer;
    }
}

//we have one more variation of similar problem
//https://leetcode.com/problems/count-number-of-nice-subarrays/

