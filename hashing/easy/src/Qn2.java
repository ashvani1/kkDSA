import java.util.Scanner;

public class Qn2 {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        int[] prefixSum=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
            sum=sum+arr[i];
            prefixSum[i]=sum;
        }
        int Q=scn.nextInt();
        while(Q>0){
            int l=scn.nextInt();
            int r=scn.nextInt();
            int right=prefixSum[r-1];
            int left=l==1?0:prefixSum[l-2];
            System.out.println(right-left);
            Q--;
        }
    }
}

//https://www.spoj.com/problems/CSUMQ/


