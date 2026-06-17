class Solution {
    public int[] runningSum(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        int runsum = 0;

        for(int i = 0 ; i < n ; i++){
            ans[i] =  runsum + nums[i];
            runsum += nums[i];
        }

        return ans;

        
    }
}