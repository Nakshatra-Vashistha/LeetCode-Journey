class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = 0;
        int result = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            maxsum = Math.max(maxsum + nums[i] , nums[i]);
            result = Math.max(result , maxsum);
        }
        return result;
        
    }
}