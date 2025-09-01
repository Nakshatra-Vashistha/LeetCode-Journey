class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minsum = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum = sum + nums[j];

                if(sum >= target){
                    minsum = Math.min(minsum , j-i+1);
                }

            }
        }
        if(minsum == Integer.MAX_VALUE){
            minsum = 0;
        }
        return minsum;
        
    }
}