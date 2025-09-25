class Solution {
    public int findLHS(int[] nums) {
        int max = 0 ;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0 ; i < n ; i++ ){
            for(int j = i + 1 ; j < n ; j++){
                if(nums[j] - nums[i] == 1){
                    max = Math.max(max , j-i+1);
                }
            }
        }
        return max;
        
    }
}