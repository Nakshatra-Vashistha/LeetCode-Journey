class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int[] min = new int[n];
        min[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            min[i] = Math.min(min[i-1] , nums[i]);
        }

        int[] max = new int[n];
        max[n-1] = nums[n-1];
        for(int j = n-2 ; j >= 0 ; j--){
            max[j] = Math.max(max[j+1] , nums[j]);
        }

        for(int i = 1 ; i<n-1 ; i++){
            if(nums[i] < max[i] && nums[i] > min[i]) return true;
        }
        
        return false;
    }
}