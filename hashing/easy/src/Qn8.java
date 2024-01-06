import java.util.*;

public class Qn8 {
    int maxLen(int arr[], int k) {
        //this map will store sum of arr elements with their indexes so whenever we found the same sum again
        //that means we found a subarray which has sum as 0 between sum's previous value in map [index] and current index
        HashMap<Integer, Integer> memo = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;

        //to handle a case when we have 0 on 0th index as Largest subarray with 0 sum
        memo.put(prefixSum, -1);

        for (int i = 0; i < k; i++) {
            int currentVal = arr[i];
            prefixSum += currentVal;

            if (memo.containsKey(prefixSum)) {

                int temp = i - memo.get(prefixSum);
                ans = Math.max(ans, temp);

            } else {
                memo.put(prefixSum, i);
            }
        }

        return ans;

    }
}

//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
