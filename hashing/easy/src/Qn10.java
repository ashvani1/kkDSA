import java.util.*;

public class Qn10 {
    public int subarraySum(int[] nums, int k) {

        int answer = 0;
        int prefixSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(prefixSum, 1);                          //as we have to find count so we are making first entry as 0 is coming 1 time

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - k)) {
                answer += map.get(prefixSum - k);
            }

            if (map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {10 , 2, -2, -20, 10};
        int k = -10;
        System.out.println(new Qn10().subarraySum(nums, k));
    }
}

//https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
