class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int i = 0 ; i < n ; i++){
            total += nums[i];
        }

        int leftsum = 0;
        for(int middleindex = 0 ; middleindex < n ; middleindex++){
            int rightsum = total - leftsum - nums[middleindex];
            if(rightsum == leftsum) return middleindex;
            leftsum += nums[middleindex];
        }
        return -1;
    }
}