import java.util.HashMap;
import java.util.Map;

public class Qn9 {
    int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //map will have key as array's value and value as occurance
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int sum = k + num;
            if (map.containsKey(sum)) {
                ans = ans + map.get(sum);
            }
        }
        return ans;
    }
}

//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/submissions/