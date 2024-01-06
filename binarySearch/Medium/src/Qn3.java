//https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/
public class Qn3 {

    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        // Edge cases:
        if (n == 1)
            return arr[0];

        if (arr[0] != (arr[1]))
            return arr[0];

        if (arr[n - 1] != (arr[n - 2]))
            return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (arr[mid] != (arr[mid + 1]) && arr[mid] != (arr[mid - 1])) {
                return arr[mid];
            }

            // We are in the left:
            //if we are on odd index and left to mid also matched with mid, then eleminate left
            //if we are on even index and right to mid also matched with mid, then also eleminate left
            if ((mid % 2 == 1 && arr[mid] == (arr[mid - 1]))
                    || (mid % 2 == 0 && arr[mid] == (arr[mid + 1]))) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement:
        return -1;
    }
}

/*
Observation
        array =>  {1,1,2,2,3,4,4}
         index => {0,1,2,3,4,5,6}

    even, odd => element is on right side [1,1]
    odd, even => element is on left side [4,4]
*/

//https://www.youtube.com/watch?v=AZOmHuHadxQ&ab_channel=takeUforward
