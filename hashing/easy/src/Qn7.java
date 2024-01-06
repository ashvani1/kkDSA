import java.util.*;
import java.util.stream.Collectors;
public class Qn7 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            // `num` is the start of a sequence.
            if (seen.contains(num - 1))
                continue;
            int length = 0;

            //how many next to current number presents in set.
            while (seen.contains(num++))
            {
                length++;
            }
            ans = Math.max(ans, length);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(new Qn7().longestConsecutive(nums));
    }
}
