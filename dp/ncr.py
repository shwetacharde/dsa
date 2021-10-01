import java.lang.*;
import java.io.*;
import java.util.*;
class GFG 
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner s=new Scanner(System.in);
        
        //taking total count of testcases
        int testcase=s.nextInt();  
        while(testcase>0)
        {
            
            
            int n=s.nextInt();              // Input n
            int r=s.nextInt();              // Input p
            
            
            //creating an object of class DynamicProgramming
            Solution obj = new Solution();
            
            //calling method nCrModp() of class
            //DynamicProgramming
            System.out.println(obj.nCrModp(n, r));
            
            testcase--;
        }
    }
     
}
// } Driver Code Ends





class Solution
{
    //Function to return nCr mod 10^9+7 for given n and r.
    public static int nCrModp(int n, int r)
    {
        // your code here
        if (r > n) {
            return 0;
        }
        r = Math.min(r, n-r);
        int mod = 1000000007;
        int dp[] = new int[n];
        
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = (dp[j] + dp[j-1])%mod;
            }
        }
        
        return dp[r]%mod;
    }
}


