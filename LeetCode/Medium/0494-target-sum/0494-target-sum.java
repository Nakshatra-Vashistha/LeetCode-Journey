class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums){
            total += num;
        }


        Integer[][] dp = new Integer[nums.length+1][2*total+1];
        return helper(nums , target , 0 , 0 , dp , total);
    }


    private int helper(int[] nums , int target , int idx, int sum , Integer[][] dp , int offset){
        if(idx >= nums.length){
            return sum == target ? 1 : 0;
        }

        if(dp[idx][sum+offset] != null){
            return dp[idx][sum+offset];
        }

        int sub = helper(nums , target , idx+1 , sum - nums[idx] , dp , offset);

        int add = helper(nums , target , idx+1 , sum + nums[idx] , dp , offset);

        return dp[idx][sum + offset] =  sub + add;
    }
}