//https://leetcode.com/contest/biweekly-contest-103/problems/find-the-prefix-common-array-of-two-arrays/import java.util.Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Qn11 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();  //this will store number and their occurence

        int count = 0;
        if(A[0] == B[0]) {
            count++;
            result[0] = count;
        }

        map.put(A[0], map.getOrDefault(A[0], 0) + 1);
        map.put(B[0], map.getOrDefault(B[0], 0) + 1);


        for(int i = 1; i < A.length; i++) {

            if(A[i] == B[i]) {
                count++;
            }
            else {
                if(map.containsKey(A[i])) {
                    count++;
                }

                if(map.containsKey(B[i])) {
                    count++;
                }
            }
            result[i] = count;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};

        System.out.println(Arrays.toString(new Qn11().findThePrefixCommonArray(A, B)));
    }
}

