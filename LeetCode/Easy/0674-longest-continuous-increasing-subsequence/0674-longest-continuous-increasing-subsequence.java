class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int len = 1;
        int left = 0;
        

        for(int right = 1 ; right < n ; right++){
            if(nums[right] > nums[right - 1]){
                len = Math.max(len , right - left + 1);
            }
            else{
                left = right;
            }
            
        }
        return len;
        
    }
}