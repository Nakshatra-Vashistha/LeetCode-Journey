class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

    
        int prev_1 = nums[0];
        int prev_2 = Math.max(nums[0] , nums[1]);

        for(int i = 2 ; i < n ; i++){
            
            int curr = prev_2;
            prev_2 = Math.max(prev_1 + nums[i] , prev_2);
            prev_1 = curr;
        }
        
        return prev_2;
    }
}