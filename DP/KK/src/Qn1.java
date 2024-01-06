public class Qn1 {
    public static void main(String[] args) {
        int n = 5; // size of the array
        int[] a = {6, 7, 3, 2, 2};

        int[] dp = new int[n + 1]; // dp array
        int i = 0;
        while (i <= n - 1) {
            if (i == 0) {
                dp[i] = a[i];
            } else {
                dp[i] = a[i] + dp[i - 1];
            }
            i++;
        }

        int q = 4; // number of queries
        int[] w = {0, 3, 4, 2}; // query array
        i = 0;
        while (i <= q - 1) {
            int query = w[i];
            System.out.println(dp[query]); // answering each query in O(1)
            i++;
        }
    }

}

/*
Problem-1 : We are given an array of integers(a[n]) . We are given multiple queries of the form : (1, i) which means we need
to output the sum of all numbers from index- ‘1’ to index ‘i’ of the array.

Analysis : Running a loop for each query[O(N)] and finding the sum is a good idea but not very efficient as it takes O(N*Q) time.

Let us create a dp-array of size ‘n’.

-->dp[1]=sum of all numbers from (1,1)

-->dp[2]=sum of all numbers from (1,2)…

and so on.

Say, a[5]={4,5,3,2,1}…(assume 1-based-indexing here) So, dp[1]=4(pretty easy)…..(1)

dp[2]=4+5=9………(2)

dp[3]=4+5+3=12…..(3) and so on.

So, for any index ‘i’ ,

dp[i]=a[i]+dp[i-1],

Example:-

dp[3] = a[3] + dp[3–1] = a[3] + dp[2]= 3 + 9 =12 ….(which is same as equation…(3))

my analysis:
we are creating a dp array here and storing results for all possible inputs so that whenever we need response for any
range we can find it out from dp array. s
*/
