import java.util.HashMap;
import java.util.Map;

public class Qn6 {
    public int longestConsecutive(int[] nums) {
        //hmap will be filled with all integer values
        Map<Integer, Boolean> hmap = new HashMap<>();
        for (int num : nums) {
            hmap.put(num, true);
        }
        int longestSequence = 0;

        Map<Integer, Integer> checkMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hmap.get(nums[i])) {
                continue;
            }
            int num = nums[i];
            int flag = 0;

            //we have to explore all array values again as below
            //if array value is present in hmap, and not present in checkMap then update hmap with false and check for prev vslue
            //if array value is present in hmap, and also present in checkMap, means we would have traverse this value with some
            //other sequence so no need to consider it now.. so update flag for differenciate
            while (hmap.containsKey(num)) {

                //check if num is already processed and have entry in checkMap
                if (checkMap.containsKey(num)) {
                    checkMap.put(nums[i], checkMap.get(num));
                    flag = -1;
                    break;
                }

                //as num is not already processed, check for num-1
                hmap.put(num, false);
                num--;
            }
            if (flag == 0) checkMap.put(nums[i], num + 1);
            int sequenceLength = nums[i] + 1 - checkMap.get(nums[i]);
            longestSequence = Math.max(longestSequence, sequenceLength);
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Qn6().longestConsecutive(nums));

    }
}
