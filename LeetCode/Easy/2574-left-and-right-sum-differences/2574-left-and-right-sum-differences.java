class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] leftsum = new int[n];
        int[] rightsum = new int[n];

        leftsum[0] = 0;
        rightsum[n-1] = 0;

        for(int i = 1 ; i < n ; i++){
            leftsum[i] = nums[i-1] + leftsum[i-1];
        }
        for(int j = n-2 ; j >= 0 ; j--){
            rightsum[j] = nums[j+1] + rightsum[j+1];
        }

        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = Math.abs(leftsum[i] - rightsum[i]);
        }

        return ans;
        
    }
}