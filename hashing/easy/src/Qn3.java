import java.util.*;
public class Qn3 {
        public static void main (String[]args) throws java.lang.Exception
        {
            // your code goes here
            int[] arr = {1, 1, 2, 2, 2, 1};
            HashMap<Integer, Integer> hm = new HashMap<>();  //we will be storing first occurance of an element with it's index
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (hm.containsKey(arr[i])) {
                    ans = Math.max(ans, i - hm.get(arr[i]));
                } else {
                    hm.put(arr[i], i);
                }
            }
            System.out.print(ans);
        }
}

//https://www.geeksforgeeks.org/maximum-distance-two-occurrences-element-array/

