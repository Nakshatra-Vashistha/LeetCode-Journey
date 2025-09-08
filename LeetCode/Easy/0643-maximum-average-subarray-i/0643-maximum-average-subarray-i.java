class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxavg = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0 ; i < k ; i++){
            sum += nums[i];

        }
        maxavg = sum;

        for(int i = k ; i < nums.length ; i++){
            sum = sum + nums[i] - nums[i - k];
            
            if(sum > maxavg){
                maxavg = sum;
            }

        }
        

        return (double)maxavg / k ;
        
    }
}