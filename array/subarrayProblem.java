//problem
//Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

//In case of multiple subarrays, return the subarray which comes first on moving from left to right.

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
         ArrayList<Integer> list = new ArrayList<Integer>();
         int sum=0,start=0,end=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            end=i;
            while(sum>s){
                sum=sum-arr[start];
                start++;
            }
            
            if(sum==s){
                break;
            }
        }
        if(sum!=s||s==0){
            list.add(-1);
            return list;
        }
        else{
            list.add(start+1);
            list.add(end+1);
             return list;
        }
          
    }
}
