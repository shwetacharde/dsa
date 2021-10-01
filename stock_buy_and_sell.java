// solution for stock buy and sell problem
// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                for (int i=0; i<ans.size(); ++i){
                    System.out.print("("+ans.get(i).get(0)+" "+ans.get(i).get(1)+") ");
                }
            }System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
         ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
         int curr = 0;
         boolean buy = true;
         ArrayList<Integer> temp = new ArrayList<Integer>();
         for (int i = 1; i < n; i++) {
             if (A[i] > A[i-1] && buy) {
                 curr = i-1;
                 buy = false;
             } else if (A[i] < A[i-1] && !buy) {
                 temp.add(curr);
                 temp.add(i-1);
                 buy = true;
                 ans.add(temp);
                 temp = new ArrayList<Integer>();
             }
         }
         if (!buy && A[n-1] > A[curr]) {
             temp.add(curr);
             temp.add(n-1);
             ans.add(temp);
         }
         return ans;
    }
}
