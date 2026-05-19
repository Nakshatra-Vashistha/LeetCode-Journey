class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return helper(nums , 0 , dp);
    }

    public static boolean helper(int[] nums , int idx , Boolean[] dp){
        if(idx >= nums.length - 1){
            return true;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        for(int i = 1 ; i <= nums[idx] ; i++){
            if(helper(nums , idx + i , dp)){
                return dp[idx] = true;
                
            }
        }

        return dp[idx] =  false;
    }
}