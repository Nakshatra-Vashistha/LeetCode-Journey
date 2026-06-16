class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;

        int ans = 0;
        int temp = 0;

        for(int i = 1 ; i < n-1 ; i++){
            if(nums[i] != nums[i+1]){
                if(nums[i] > nums[temp] && nums[i] > nums[i+1] || nums[i] < nums[temp] && nums[i] < nums[i+1]){
                    ans++;
                }
                temp = i;
            
            }
            
        }

        return ans;
    }
}